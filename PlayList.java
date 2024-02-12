/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }



    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    


    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        /// First we will deal with the case that the playlist is full- in this case the method will return false
        if (this.size == this.maxSize) {
            return false; 
        } 
        else if (this.size == 0) {
            tracks[0] = track;   
        } 
        else if (this.size < this.maxSize) {
            tracks[this.size] = track;
        }
        /// If the playlist isn't full, we will add the input track to the track list in the last place
        /// We will also have to update the size value of the playlist- and increase it by one track  
        this.size++ ; 
        return true;
    }



    public String toString() {
        /// Using StringBuilder we will create the return string in increments
        /// Using a loop we will go over all of the songs and add the track info to our string
        /// In the end we will return the string we've built as a string, rather than a StringBuilder object
        StringBuilder ansString = new StringBuilder();
        for (int i = 0; i < size; i ++) {
            ansString.append("\n"); 
            ansString.append(tracks[i].toString());
        }
        return ansString.toString();
    }



    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
        //// First we will deal with the case that the tracklist is empty
        if (this.size == 0) {
            
        }
        else { 
            tracks[this.size] = null; 
            this.size = this.size - 1; 
        }
    }
    


    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        /// to calculate the length of the playlist we will use a loop to go over each song, add it's duration and return the sum. 
        int sumDuration = 0; 
        if (this.size == 0) {
            return 0; 
        } else { 
            for (int i = 0; i < this.size; i++) {
                sumDuration = sumDuration + tracks[i].getDuration(); 
            }
        }
        return sumDuration;
    }



    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        /// To check if a song is in the playlist we will go over all of the songs in the playlist and check if their title matches
        /// the given title. 
        /// If it does - return the idx of the track
        /// If it doesn't - return -1  
        for (int i = 0; i < this.size; i++) {
            if (title.equals(tracks[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }



    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        //// To start we will deal with the easier cases- that the playlist is empty & that the track is added to the last place
        if (this.size == 0) {
            tracks[0] = track; 
            this.size++ ;  
            return true; 
        }
        if (this.size == i + 1) {
            tracks[i + 1] = track; 
            this.size++ ;
            return true;
        }
        //// We will start by checking that th conditions for adding a track to the playlist apply: 
        //// The playlist isn't full + the idx given is valid
        //// If both conditions apply then we can add songs to the playlist
        //// First we will want to shift all of the songs that come after the given idx one place to the right
        //// Then we will add the new song to our 'hole'
        if (i > 0 || i < this.maxSize) {
            if (this.size < this.maxSize) {
                for (int r = this.size; r >= i; r--) {
                    tracks[r+1] = tracks[r];
                }
                tracks[i] = track; 
                this.size++ ;
                return true; 
            }
        }
        //// replace the following statement with your code
        return false;
    }
     


    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
        /// We will start with the cases where the function returns -1
        if (this.size == 0 || this.size < 0 || this.size > this.maxSize) {
            System.out.println(-1); 
        } 
        /// Next we will deal with the cases where a song is actually deleted: 
        /// First we will remove the song from the given idx
        /// Next we will shift all of the other songs to the left
        tracks[i] = null; 
        for (int j = i; j < this.size; j++) {
            tracks[j] = tracks[j+1]; 
        }
        this.size-- ;

    }



    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) {
        /// First we will deal with the cases where the function does nothing
        if (this.size == 0) {
            
        } 
        /// Next we will create a loop that goes over all the tracks in the playlist
        /// if the given title matches the title of a track on the playlist- we remove it
        /// if the title doesn't match any track on the playlist- we do nothing
        else {
            for (int i = 0; i < this.size; i++) {
                if (title.equals(tracks[i].getTitle())) {
                    if (i > 0 && i < this.maxSize){
                        remove(i);
                    }
                }
            }
            
        }
    }



    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        /// First we will deal with the cases where the function does nothing
        if (this.size == 0) {
            
        } else {
        /// Next we will remove the first song from the playlist and shift all of the songs to the left 
            tracks[0] = null; 
            for (int j = 0; j < this.size; j++) {
                tracks[j] = tracks[j+1]; 
            }
            this.size-- ;
        }

    }
    


    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        /// First we will deal with the cases where the function does nothing
        if (this.size + other.getSize() > this.maxSize) {

        } else {
        /// Next we will add the songs from the other playlist to our original playlist, in order of appearance  
            for (int i = 0; i < other.size; i++) {
                this.add(other.getTrack(i));
            } 
        }
    }



    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        /// First we will deal with the cases where the function does nothing
        if (start < 0 || start > this.size) {
            return -1; 
        }
        /// Next we will use a loop to go over all of the songs in the playlisy
        /// if the current's song duration is shorter than our previous songs- we will change the idx  
        int ans = start;  
        for (int i = start; i < this.size; i++) {
            if (tracks[i].getDuration() < tracks[ans].getDuration()) {
                ans = i; 
            } 
        }
        return ans;
    }



    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() {
        if (this.size == 0) {
            return null; 
        }
        return tracks[minIndex(0)].getTitle();
    }



    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        int idx = 0; 
        for (int i = 0; i < this.size; i++) {
            idx = minIndex(i); 
            Track temp = tracks[i];
            tracks[i] = tracks[idx];
            tracks[idx] = temp;    
            }
        }
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
    }

