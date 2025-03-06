package BigWigs;

public class Spell {
    private String boss;
    private String spellID;

    protected Spell(String boss, String spellID) {
        this.boss = boss;
        this.spellID = spellID;
    }

    public String getBoss() { return boss; }
    public String getSpellID() { return spellID; }

    @Override
    public String toString() {
        return boss + " " + spellID;
    }
}
