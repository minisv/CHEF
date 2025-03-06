package BigWigs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class All extends BigWigs {
    public All(File folder, String fileType) {
        super(folder, fileType);
    }

    @Override
    protected void addCheckFiles() {
        super.addCheckFiles();
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-bfa-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-bfa-raid.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-cat-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-dra-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-dra-raid.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-leg-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-leg-raid.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-leg-scen.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-mop-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-sha-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-sha-raid.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-tww-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-tww-raid.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-tww-scen.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-wod-dung.txt");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs_Voice/refs/heads/master/Tools/spells-wod-raid.txt");
    }

    @Override
    protected void makeSpellList(String inputLine, ArrayList<Spell> spellList) {
        super.makeSpellList(inputLine, spellList);
        if (!inputLine.isEmpty() && !inputLine.startsWith(";")) {
            spellList.add(new Spell(null, inputLine.substring(0, inputLine.indexOf("\t"))));
        }
    }

    @Override
    protected void existFileCheck(HashSet<String> recordedFiles, ArrayList<Spell> noExistFiles, Spell spell) {
        super.existFileCheck(recordedFiles, noExistFiles, spell);
        if (!recordedFiles.contains(spell.getSpellID())) noExistFiles.add(spell);
    }
}
