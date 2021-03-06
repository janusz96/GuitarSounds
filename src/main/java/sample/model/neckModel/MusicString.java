package sample.model.neckModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 20.10.2017.
 */
public class MusicString {
    private ObservableMap<Integer, SoundOnNeck> sounds = FXCollections.observableHashMap();

    public MusicString(int length, Sound firstSound){
        SoundsNames[] values = SoundsNames.values();
        int firstSoundOrdinal = firstSound.getName().ordinal();
        for (int i = 0; i < length; i++){
            int octave = (firstSoundOrdinal + i) / 12;
            SoundsNames soundName = values[(firstSoundOrdinal + i) % values.length];
            sounds.put(i, new SoundOnNeck(soundName, octave + firstSound.getOctave()));
        }
    }

    public List<SoundOnNeck> getSounds(){
        return new ArrayList<>(sounds.values());
    }

    public SoundOnNeck getSound(int i){
        return sounds.get(i);
    }

    public int getNumberOfSounds() {
        return sounds.size();
    }
}
