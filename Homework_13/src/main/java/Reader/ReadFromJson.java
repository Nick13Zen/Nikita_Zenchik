package Reader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to read from json file
 * Created by Nikita Zenchik.
 */
public class ReadFromJson extends Reader {

    private File file;

    public ReadFromJson(File file) {
        this.file = file;
    }

    /**
     * Method to read from json file.
     */
    @Override
    public ArrayList<String> readCommands() throws IOException {
        ArrayList<String> listOfCommands = new ArrayList<String>();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonFileData = jsonParser.parse(new JsonReader(new FileReader(file)));
        JsonArray jsonArray = jsonFileData.getAsJsonObject().get("commands").getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            listOfCommands.add(jsonArray.get(i).getAsString());
        }
        return listOfCommands;
    }
}
