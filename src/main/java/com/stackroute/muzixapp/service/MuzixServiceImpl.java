package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
    private MuzixRepository muzixRepository;
//    private Muzix muzix1;

    @Autowired
    public MuzixServiceImpl( MuzixRepository userRepository){
        this.muzixRepository=userRepository;
    }

    public MuzixServiceImpl(){}
    @Override
    public Muzix saveUser(Muzix muzix) throws TrackAlreadyExistsException {
        if(!muzixRepository.existsById(muzix.getTrackId())){
            throw new TrackAlreadyExistsException("Track is already present");
        }
        Muzix savedUser=muzixRepository.save(muzix);
        if(savedUser==null){
            throw new TrackAlreadyExistsException("Track was already pressent");
        }
        return savedUser;
    }

    @Override
    public List<Muzix> getAllUsers()  {
        return muzixRepository.findAll();
    }

    @Override
    public List<Muzix> deleteById(int trackId) throws TrackNotFoundException
    {
        if(!muzixRepository.existsById(trackId)){
            throw new TrackNotFoundException("track is not present");
        }
        muzixRepository.deleteById(trackId);
        return muzixRepository.findAll();

    }
    @Override
    public boolean findById(int  trackId) throws TrackNotFoundException{
      if( !muzixRepository.existsById(trackId)){
          throw new TrackNotFoundException("track not found");
        }
         muzixRepository.findById(trackId);
        return true;

    }
    @Override
    public ResponseEntity<Object> updateMuzix(Muzix muzix, int id)throws TrackNotFoundException {
        Optional<Muzix> trackOptional = muzixRepository.findById(id);
        if (!trackOptional.isPresent()) {
            throw new TrackNotFoundException("track is not present");

        }

       muzix.setTrackId(id);
        muzixRepository.save(muzix);
        return ResponseEntity.noContent().build();
    }
    @Override
    public List<Muzix> getMuzixByName1(String name)throws TrackNotFoundException{
        if(muzixRepository.getMuzixByName(name).isEmpty()){
            throw new TrackNotFoundException((" track not found"));
        }
         return muzixRepository.getMuzixByName(name);

    }




}
