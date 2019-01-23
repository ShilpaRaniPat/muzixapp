package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MuzixService {

    public Muzix saveUser(Muzix muzix) throws TrackAlreadyExistsException;



        public List<Muzix> getAllUsers() ;
        public List<Muzix> deleteById(int trackId) throws TrackNotFoundException;
       public ResponseEntity<Object> updateMuzix(Muzix muzix, int trackId) throws TrackNotFoundException;
        public boolean findById(int trackId) throws TrackNotFoundException;
        public List<Muzix> getMuzixByName1(String name) throws TrackNotFoundException;

    }




