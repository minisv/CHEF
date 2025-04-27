package BigWigs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class Season extends BigWigs {

    private String boss;
    private boolean isAddSpell;
    private ArrayList<String> bossList;

    public Season(File folder, String fileType) {
        super(folder, fileType);
    }

    private void seasonBossList() {
        bossList = new ArrayList<>();
        /**
         * LibrationOfUndermine
         */
        bossList.add("Vexie and the Geargrinders");
        bossList.add("Cauldron of Carnage");
        bossList.add("Rik Reverb");
        bossList.add("Stix Bunkjunker");
        bossList.add("Sprocketmonger Lockenstock");
        bossList.add("The One-Armed Bandit");
        bossList.add("Mug'Zee, Heads of Security");
        bossList.add("Chrome King Gallywix");

        /**
         * WarWithIn Operation: Floodgate
         */
        bossList.add("Big M.O.M.M.A.");
        bossList.add("Demolition Duo");
        bossList.add("Swampface");
        bossList.add("Geezle Gigazap");
        bossList.add("Operation: Floodgate Trash");

        /**
         * WarWithIn Cinderbrew Meadery
         */
        bossList.add("Brew Master Aldryr");
        bossList.add("I'pa");
        bossList.add("Benk Buzzbee");
        bossList.add("Goldie Baronbottom");
        bossList.add("Cinderbrew Meadery Trash");

        /**
         * WarWithIn Drakflame Cleft
         */
        bossList.add("Ol' Waxbeard");
        bossList.add("Blazikon");
        bossList.add("The Candle King");
        bossList.add("The Darkness");
        bossList.add("Darkflame Cleft Trash");

        /**
         * WarWithIn Priory Of The Sacred Flame
         */
        bossList.add("Captain Dailcry");
        bossList.add("Baron Braunpyke");
        bossList.add("Prioress Murrpray");
        bossList.add("Priory of the Sacred Flame Trash");

        /**
         * WarWithIn The Rookery
         */
        bossList.add("Kyrioss");
        bossList.add("Stormguard Gorren");
        bossList.add("Voidstone Monstrosity");
        bossList.add("The Rookery Trash");

        /**
         * Battle For Azeroth Mechagon Workshop
         */
        bossList.add("Tussle Tonks");
        bossList.add("K.U.-J.0.");
        bossList.add("Machinist's Garden");
        bossList.add("King Mechagon");
        bossList.add("Operation: Mechagon Trash");

        /**
         * Battle For Azeroth The Motherlode
         */
        bossList.add("Coin-Operated Crowd Pummeler");
        bossList.add("Azerokk");
        bossList.add("Rixxa Fluxflame");
        bossList.add("Mogul Razdunk");
        bossList.add("The MOTHERLODE!! Trash");

        /**
         * Shadowlands Theater Of Pain
         */
        bossList.add("An Affront of Challengers");
        bossList.add("Gorechop");
        bossList.add("Xav the Unfallen");
        bossList.add("Kul'tharok");
        bossList.add("Mordretha, the Endless Empress");
        bossList.add("Theater Of Pain Trash");
    }

    @Override
    protected void addCheckFiles() {
        super.addCheckFiles();
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/BigWigs/refs/heads/master/LiberationOfUndermine/!Options.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/WarWithin/!Options.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/BfA/!Options.lua");
        checkFiles.add("https://raw.githubusercontent.com/BigWigsMods/LittleWigs/refs/heads/master/Shadowlands/!Options.lua");

        seasonBossList();
        isAddSpell = false;
    }

    @Override
    protected void makeSpellList(String inputLine, ArrayList<Spell> spellList) {
        super.makeSpellList(inputLine, spellList);
        inputLine = inputLine.trim();
        if (inputLine.startsWith("[") && !inputLine.startsWith("[\"") && isAddSpell) {
            spellList.add(new Spell(boss, inputLine.substring(inputLine.indexOf("[") + 1, inputLine.indexOf("]"))));
        } else if (inputLine.startsWith("BigWigs:AddSounds")) {
            String finalInputLine = inputLine;
            bossList.forEach(bossName -> {
                if (finalInputLine.contains(bossName)) {
                    isAddSpell = true;
                    boss = bossName;
                }
            });
        } else if (inputLine.startsWith("})")) {
            isAddSpell = false;
        }
    }

    @Override
    protected void existFileCheck(HashSet<String> recordedFiles, ArrayList<Spell> noExistFiles, Spell spell) {
        super.existFileCheck(recordedFiles, noExistFiles, spell);
        if (!recordedFiles.contains(spell.getSpellID())) noExistFiles.add(spell);
    }
}
