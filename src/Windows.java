import BigWigs.All;
import BigWigs.Season;
import BigWigs.Spell;
import DBM.DBM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

public class Windows extends Frame {

    private CheckboxGroup programGroup;
    private CheckboxGroup fileTypeGroup;
    private File directory;
    private Button checkExistFilesButton;
    private TextArea spellArea;
    private TextArea usageArea;
    private Label statusLabel;

    Windows() {
        setLayout(null);

        voicePackType();
        fileType();
        selectVoicePackFolder();
        checkExistFiles();
        textArea();
        state();

        setSize(600, 600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);
        setTitle("DBM / BigWigs 보이스 팩 누락 파일 검사 프로그램 - 미니룬 (디코: minirune)");
        setIconImage(new ImageIcon(getClass().getResource("resources/images/wowbot.png")).getImage());
        setVisible(true);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void voicePackType() {
        Label voicePackTypeLabel = new Label("보이스 팩 타입을 골라주세요: ");
        voicePackTypeLabel.setBounds(20, 40, 220, 30);
        add(voicePackTypeLabel);

        programGroup = new CheckboxGroup();
        Checkbox dbm = new Checkbox("DBM", true, programGroup);
        Checkbox bigwigs = new Checkbox("BigWigs", false, programGroup);
        Checkbox bigwigsSeasonOnly = new Checkbox("BigWigs Season Only", false, programGroup);
        dbm.setBounds(240, 40, 80, 30);
        bigwigs.setBounds(320, 40, 100, 30);
        bigwigsSeasonOnly.setBounds(420, 40, 180, 30);
        add(dbm);
        add(bigwigs);
        add(bigwigsSeasonOnly);
    }

    private void fileType() {
        Label soundFileTypeLabel = new Label("녹음한 파일 타입을 골라주세요: ");
        soundFileTypeLabel.setBounds(20, 70, 220, 30);
        add(soundFileTypeLabel);

        fileTypeGroup = new CheckboxGroup();
        Checkbox ogg = new Checkbox("ogg", true, fileTypeGroup);
        Checkbox mp3 = new Checkbox("mp3", false, fileTypeGroup);
        ogg.setBounds(240, 70, 80, 30);
        mp3.setBounds(320, 70, 80, 30);
        add(ogg);
        add(mp3);
    }

    private void selectVoicePackFolder() {
        Button selectVoicePackFolderButton = new Button("보이스팩 폴더를 선택해주세요: ");
        selectVoicePackFolderButton.setBounds(20, 100, 560, 30);
        add(selectVoicePackFolderButton);
        selectVoicePackFolderButton.addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showDialog(selectVoicePackFolderButton, null);
            directory = fileChooser.getSelectedFile();

            boolean enable = directory != null;
            checkExistFilesButton.setEnabled(enable);
            if (enable) statusLabel.setText("폴더 : "+directory.getAbsolutePath());
        });
    }

    private void checkExistFiles() {
        checkExistFilesButton = new Button("파일 체크를 시작 합니다!");
        checkExistFilesButton.setBounds(20, 130, 560, 30);
        add(checkExistFilesButton);
        checkExistFilesButton.setEnabled(false);
        checkExistFilesButton.addActionListener(event -> {

            String program = programGroup.getSelectedCheckbox().getLabel();
            String fileType = fileTypeGroup.getSelectedCheckbox().getLabel();
            switch (program) {
                case "DBM" -> {
                    spellArea.setText("");
                    DBM dbm = new DBM(directory, fileType);
                    ArrayList<String> noExistFiles = dbm.getNoExistFiles();
                    noExistFiles.forEach(spellArea::append);
                    statusLabel.setText("확인된 누락 갯수는 " + noExistFiles.size() + "개 입니다.");
                }
                case "BigWigs" -> {
                    showDialog("전체 확인: 확인 버튼을 누르고 잠시 기다려 주세요.");
                    spellArea.setText("");
                    All all = new All(directory, fileType);
                    ArrayList<Spell> noExistFiles = all.getNoExistSpells();
                    noExistFiles.forEach(spell -> {
                        spellArea.append(spell.getSpellID() + "\n");
                    });
                    statusLabel.setText("확인된 누락 갯수는 " + noExistFiles.size() + "개 입니다. 체크 대상 파일 갯수는 " + all.getRecordedFiles() + "개 입니다.");
                }
                case "BigWigs Season Only" -> {
                    showDialog("시즌 확인: 확인 버튼을 누르고 잠시 기다려 주세요.");
                    spellArea.setText("");
                    Season season = new Season(directory, fileType);
                    ArrayList<Spell> noExistFiles = season.getNoExistSpells();
                    noExistFiles.forEach(spell -> {
                        spellArea.append(spell.getSpellID() + "\n");
                        usageArea.append(spell.toString() + "\n");
                    });
                    statusLabel.setText("확인된 누락 갯수는 " + noExistFiles.size() + "개 입니다. 체크 대상 파일 갯수는 " + season.getRecordedFiles() + "개 입니다.");
                }
            }
        });
    }

    private void textArea() {
        spellArea = new TextArea();
        spellArea.setBounds(20, 160, 130, 390);
        usageArea = new TextArea();
        usageArea.setBounds(150, 160, 430, 390);
        add(spellArea);
        add(usageArea);
    }

    private void state() {
        statusLabel = new Label();
        statusLabel.setBounds(20, 550, 560, 30);
        add(statusLabel);
    }

    private void showDialog(String message) {
        Dialog info = new Dialog(this, "안내", true);
        info.setSize(400, 100);
        info.setLocationRelativeTo(this);
        info.setLayout(new FlowLayout(FlowLayout.CENTER));

        Label label = new Label(message);
        info.add(label);

        Button close = new Button("확인");
        info.add(close);

        close.addActionListener(event -> info.dispose());
        info.setVisible(true);
    }
}
