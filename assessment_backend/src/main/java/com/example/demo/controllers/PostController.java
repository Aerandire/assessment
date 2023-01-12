package com.example.demo.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.List;
import com.example.demo.repositories.PostRepository;
import com.example.demo.services.storeImageService;


@RestController
@RequestMapping(path="api/posting", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    @Autowired
    private storeImageService siSvc;

    @Autowired
    private PostRepository postRepo;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> postListing(@RequestPart String name, 
    @RequestPart String email, @RequestPart String phone, @RequestPart String title, @RequestPart String description, @RequestPart("image") MultipartFile image) throws IOException{

        //Get posting ID
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0,8);

        //Get posting date
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);

        //Upload image and set url
        String key = siSvc.saveFile(image);
        String imageURL = "https://aer.sgp1.digitaloceanspaces.com" + key;

        
        List holdList = new List();
        holdList.setPostingID(id);
        holdList.setPostingDate(strDate);
        holdList.setName(name);
        holdList.setEmail(email);
        holdList.setPhone(phone);
        holdList.setTitle(title);
        holdList.setDescription(description);
        holdList.setImage(imageURL);
        String values = holdList.toJson().toString();

        //Redis upload key and values
    
        //Return back to frontend
        return ResponseEntity.ok(values);
    }

    @PutMapping("api/posting/{posting_id}")
    public ResponseEntity<String> putListing(@PathVariable String posting_id){

        //retrieve from redis

        List putList = new List();
        //Load all the retrieve values in
        //putList.create();

        //Store into db
        if (postRepo.insertPosting(putList) == true)
            return ResponseEntity.ok("{message: 'Accepted" + posting_id + "'}");
        else
            return ResponseEntity.ok("{message: 'Posting ID " + posting_id + "not found}'");
    }
    
}
