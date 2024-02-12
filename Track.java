/** Represents a music track. A track has a title (String), an artist (String), 
 *  and a duration (int), in seconds. */
class Track {
    private String title;
    private String artist;
    private int duration;

    /** Constructs a track from the given values. */
    public Track(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    /** Returns this track's data as "artist, title, minutes:seconds".
     *  For example, "John Lennon, Imagine, 3:07" */
    public String toString() {
        String duration = formattedDuration(getDuration()); 
        return artist + ", " + title + ", " + duration;
    }

    /** Returns this track's title. */
    public String getTitle() {
        return title;
    }
    /** Returns this track's artist. */
    public String getArtist() {
        return artist;
    }
    /** Returns this track's duration. */
    public int getDuration() {
        return duration;
    }

    /** If this track's duration is shorter than the other track's duration
     *  returns true; otherwise returns false. */
    public boolean isShorterThan(Track other) {
        int originalTrack = this.duration;
        int otherTrack = other.getDuration(); 
        return originalTrack < otherTrack;
    }


    private String formattedDuration(int totalSeconds) {
        /// In this code our main challenge is to switch the time unit from seconds to minutes and seconds
        /// First we will calculate the integers of mintues and seconds. 
        /// Next, we want to assert sensible formatting, therefore we will divide to 2 cases: 
        /// If the track duration has a value of less than 10- we will add a 0 to the formatting and after that concatenate the int
        /// If the track duration has a value of 10 or greater- we will use the formatting supplied by the course staff  
        int secondsDuration = totalSeconds % 60;   
        int minutesDuration = totalSeconds / 60;
        if (secondsDuration < 10) {
            return "" + minutesDuration + ":0" + secondsDuration; 
        }
        return "" + minutesDuration + ":" + secondsDuration;
    }
}