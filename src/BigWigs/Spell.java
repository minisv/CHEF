package BigWigs;

public class Spell {
    private final String boss;
    private final String spellID;

    protected Spell(String boss, String spellID) {
        this.boss = boss;
        this.spellID = spellID;
    }

    public String getBoss() { return boss; }
    public String getSpellID() { return spellID; }

    @Override
    public String toString() {
        return spellID + ", " + boss;
    }
}
