package BigWigs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class Season extends BigWigs {

    private String boss;

    public Season(File folder, String fileType) {
        super(folder, fileType);
    }

    @Override
    protected void addCheckFiles() {
        super.addCheckFiles();
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs/refs/heads/master/LiberationOfUndermine/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/BfA/Mechagon/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/BfA/TheMotherlode/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/Shadowlands/TheaterOfPain/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/WarWithin/CinderbrewMeadery/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/WarWithin/DarkflameCleft/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/WarWithin/TheRookery/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/WarWithin/PrioryOfTheSacredFlame/Options/Sounds.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/WarWithin/OperationFloodgate/Options/Sounds.lua");
    }

    @Override
    protected void makeSpellList(String inputLine, ArrayList<Spell> spellList) {
        super.makeSpellList(inputLine, spellList);
        inputLine = inputLine.trim();
        if (inputLine.startsWith("[") && !inputLine.startsWith("[\"")) {
            spellList.add(new Spell(boss, inputLine.substring(inputLine.indexOf("[") + 1, inputLine.indexOf("]"))));
        } else if (inputLine.startsWith("BigWigs:AddSounds")) {
            boss = inputLine.substring(inputLine.indexOf("\"")+1, inputLine.lastIndexOf("\""));
        }
    }

    @Override
    protected void existFileCheck(HashSet<String> recordedFiles, ArrayList<Spell> noExistFiles, Spell spell) {
        super.existFileCheck(recordedFiles, noExistFiles, spell);
        if (!recordedFiles.contains(spell.getSpellID())) noExistFiles.add(spell);
    }
}
