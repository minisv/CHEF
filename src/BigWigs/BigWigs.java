package BigWigs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class BigWigs {

    private final ArrayList<Spell> allSpells;
    private ArrayList<Spell> spellList;
    private final ArrayList<Spell> noExistSpells;
    private final HashSet<String> recordedFiles;
    protected ArrayList<String> checkFiles;
    protected ArrayList<String> noMoreUseFiles;

    public BigWigs(File folder, String fileType) {
        allSpells = new ArrayList<>();
        noExistSpells = new ArrayList<>();
        recordedFiles = new HashSet<>();
        noMoreUseFiles = new ArrayList<>();
        addCheckFiles();
        folderIndexing(folder, fileType);

        checkFiles.forEach(file -> {
            try {
                URL url = new URL(file);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setDoOutput(true);

                int responseCode = connection.getResponseCode();

                if (responseCode != HttpURLConnection.HTTP_OK) {
                    System.out.println(file + " BigWigs Script 에서 spell ID 를 읽어오지 못하였습니다");
                }

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                spellList = new ArrayList<>();
                String inputLine;

                while ((inputLine = bufferedReader.readLine()) != null) {
                    makeSpellList(inputLine, spellList);
                }
                allSpells.addAll(spellList);
                bufferedReader.close();
                connection.disconnect();

                spellList.forEach(spell -> {
                    existFileCheck(recordedFiles, noExistSpells, spell);
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        noMoreUseFiles.addAll(recordedFiles);
        allSpells.forEach(spell -> {
            if (recordedFiles.contains(spell.getSpellID())) noMoreUseFiles.remove(spell.getSpellID());
        });
    }

    public ArrayList<Spell> getNoExistSpells() { return noExistSpells; }
    public int getRecordedFiles() { return recordedFiles.size(); }
    public ArrayList<String> getNoMoreUseFiles() { return noMoreUseFiles; }

    protected void addCheckFiles() {
        checkFiles = new ArrayList<>();
    }

    protected void makeSpellList(String inputLine, ArrayList<Spell> spellList) {}

    protected void existFileCheck(HashSet<String> recordedFiles, ArrayList<Spell> noExistFiles, Spell spell) {}

    private void folderIndexing(File folder, String fileType) {
        File[] files = folder.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            if (file.isDirectory()) {
                folderIndexing(file, fileType);
            } else {
                if (file.getName().endsWith(fileType)) {
                    String fileName = file.getName();
                    recordedFiles.add(fileName.substring(0, fileName.indexOf(".")));
                }
            }
        }
    }
}
