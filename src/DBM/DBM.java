package DBM;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DBM {

    ArrayList<String> noExistFiles;

    public DBM(File folder, String fileType) {
        noExistFiles = new ArrayList<>();

        final String dbmURL = "https://raw.githubusercontent.com/DeadlyBossMods/DBM-Voicepack-Demo/master/DBM-VPDemo/!VoiceText.txt";

        try {
            URL url = new URL(dbmURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("DBM Voicepack Demo 에서 voiceText 를 읽어오지 못하였습니다.");
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            ArrayList<String> soundList = new ArrayList<>();
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                if (inputLine.indexOf("\"")==0) {
                    String soundName = inputLine.substring(inputLine.indexOf("\"")+1, inputLine.indexOf(" ")-1);
                    if (!soundName.contains("/") && (!soundName.contains("_"))) soundList.add(soundName);
                }
            }
            bufferedReader.close();
            connection.disconnect();

            File realFile;
            for (String s : soundList) {
                realFile = new File(folder + File.separator + s + "." + fileType);
                if (!realFile.exists()) {
                    noExistFiles.add(s + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getNoExistFiles() {
        return noExistFiles;
    }
}
