package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.repository.MuzixRepository;
import com.stackroute.muzixapp.service.MuzixService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping(value="api/v1")
    public class MuzixController {
        MuzixService muzixService;
        @Autowired
        public MuzixController(MuzixService muzixService){
            this.muzixService=muzixService;
        }
    MuzixRepository muzixRepository;

    public MuzixController(MuzixRepository muzixRepository){
        this.muzixRepository=muzixRepository;
    }

        @PostMapping("muzix")
        public ResponseEntity<?> saveUser(@RequestBody  Muzix muzix){
            ResponseEntity responseEntity;
            try{
                muzixService.saveUser(muzix);
                responseEntity=new ResponseEntity<String>("creation successful", HttpStatus.CREATED);
            }
            catch (Exception ex){ responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

            }
            return responseEntity;


        }
        @GetMapping("muzix")
        public ResponseEntity<?> getAllUsers(){
            return new ResponseEntity<List<Muzix>>( muzixService.getAllUsers(),HttpStatus.OK);

        }
        @DeleteMapping("muzix/{trackId}")
        public ResponseEntity<?> deleteUser(@PathVariable int trackId){
            muzixService.deleteById(trackId);
            return new ResponseEntity<List<Muzix>>( muzixService.getAllUsers(),HttpStatus.OK);
        }
        @PutMapping("/muzix/{trackId}")
        public ResponseEntity<Object> updateUser(@RequestBody Muzix muzix, @PathVariable int trackId) {



            Optional<Muzix> muzixOptional = muzixRepository.findById(trackId);

            if (!muzixOptional.isPresent())
                return ResponseEntity.notFound().build();

            muzix.setTrackId(trackId);

            muzixRepository.save(muzix);

            return ResponseEntity.noContent().build();
        }
        @GetMapping(value = "/muzix/{name}")
        public ResponseEntity<List<Muzix>> getTrackByName(@PathVariable String name)
        {
            ResponseEntity responseEntity;
            try {

                return new ResponseEntity <List<Muzix>>(muzixService.getMuzixByName(name),HttpStatus.OK);
            }
            catch (Exception ex)
            {
                responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            }
            return responseEntity;
        }


    }


