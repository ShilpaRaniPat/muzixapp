package com.stackroute.muzixapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Muzix {
    @Id
    private int trackId;
    private String trackName;
    private String trackComment;
}

//    public Muzix(){
//
//    }
//
//    @Override
//    public String toString() {
//        return "Muzix{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                ", trackComment='" + trackComment + '\'' +
//                '}';
//    }
//
//    public Muzix(int trackId, String trackName, String trackComment){
//
//        this.trackId=trackId;
//        this.trackName=trackName;
//        this.trackComment=trackComment;
//    }
//
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getTrackComment() {
//        return trackComment;
//    }
//
//    public void setTrackComment(String trackComment) {
//        this.trackComment = trackComment;
//    }
//
//
//
//
//}
