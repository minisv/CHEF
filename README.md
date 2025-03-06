# CHEF
CHeck Exist Files your voice pack

### 개발 목적
[DBM](https://github.com/DeadlyBossMods/DeadlyBossMods) 또는 [BigWigs](https://github.com/BigWigsMods/BigWigs) 보이스 팩 음성을 녹음 해주시는 분들을 위하여 누락된 (업데이트된) 파일을 쉽게 찾기 위해 제작 되었습니다.

### 개발 상태
[DBM](https://github.com/DeadlyBossMods/DeadlyBossMods) 과 [BigWigs](https://github.com/BigWigsMods/BigWigs) 를 지원하고 있습니다.
BigWigs 는 '전체 확인' 과 '시즌 확인' 두가지를 지원하고 있습니다.

### 라이선스
- 이 프로젝트는 [World of Warcraft](https://worldofwarcraft.blizzard.com/)의 [DBM](https://github.com/DeadlyBossMods/DeadlyBossMods) 과 [BigWigs](https://github.com/BigWigsMods/BigWigs) 의 보이스 팩 음성을 만들어 주시는 분들을 위하여 만들어 졌습니다. 프로그램의 사용은 누구나 '무료' 로 할 수 있습니다.
- 이 프로젝트는 소스를 공개한 오픈 소스 프로젝트(Open Source Project) 입니다.
- 이 프로젝트는 [CC BY-NC 한글](https://creativecommons.org/licenses/by-nc/4.0/deed.ko), [CC BY-NC English](https://creativecommons.org/licenses/by-nc/4.0/) 를 따릅니다. 누구나 무료로 이용할 수 있지만, 상업적으로 사용해선 안됩니다.

### How to Java install or uninstall
- [Amazon Corretto 17 for Mac](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/macos-install.html)
- 혹시나, 본인의 Mac 이 M1 이후 실리콘 맥 모델이라면 aarch64 로 받으셔야 합니다. 인텔맥 이라면 x64 로 받으세요. pkg 로 받아서 설치 하시면 됩니다.
- [Amazon Corretto 17 for Windows](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/windows-install.html)

### How to Use for Windows (초보자 설명)
1. Java 를 먼저 설치 하여야 합니다. 위의 How to Java install 부분을 자신의 OS에 맞게 셋팅 하여주세요.
2. Jar 를 다운로드 받아야 합니다. [CHEF Jar 다운로드](https://github.com/minisv/CHEF/raw/refs/heads/main/download/CHEF.jar) 받기
3. Window 키 + E 를 눌러 나온 윈도우 탐색기에서 다운로드 폴더를 즐겨찾기 해 두신 경우라면 클릭하여 확인해주세요. 보통 위치는 C:\Users\{여러분이 지정한 ID}\Downloads 입니다.
4. Windows 용 '명령 프롬프트' 를 실행 합니다. Window 키 + R 을 누릅니다. CMD 라고 입력해 주시고 엔터를 입력해주세요.
5. 명령 프롬프트가 열려져 있는 상태에서 "java -jar " 까지 입력 합니다. 마지막에 한칸 띄워져 있어야 해요.
6. 윈도우 탐색기에서 다운로드 받은 CHEF.jar 파일을 명령 프롬프트로 드래그 앤 드랍 해줍니다.
7. 그러면 java -jar C:\Users\{여러분이 지정한 ID}\Downloads\CHEF.jar 라고 될 것입니다. 맞다면 엔터를 눌러주세요.
8. Enjoy CHEF!

### How to Use for Mac (초보자 설명)
1. Java 를 먼저 설치 하여야 합니다. 위의 How to Java install 부분을 자신의 OS에 맞게 셋팅 하여주세요.
2. Jar 를 다운로드 받아야 합니다. [CHEF Jar 다운로드](https://github.com/minisv/CHEF/raw/refs/heads/main/download/CHEF.jar) 받기
3. Mac 의 Dock (앱들이 나열되어 있는 것을 Dock 이라 합니다.) 의 맨 오른쪽 휴지통의 바로 왼쪽은 '다운로드 폴더' 입니다.
4. 다운로드 폴더에 마우스를 위치 시키고 두손가락으로 클릭 혹은 오른쪽 마우스 버튼으로 누르면 나오는 팝업 메뉴에서 '다운로드'열기 를 눌러주세요.
5. Finder 가 오픈되고, 다운로드 폴더의 아이템을 보여주게 되는데, 거기에서 CHEF.jar 파일을 확인하세요.
6. Command + Space Bar 를 눌러 Spot Light 를 띄워줍니다. 터미널 이라고 입력하면 앱이 검색됩니다. 엔터를 입력해주세요.
7. 터미널이 열려져 있는 상태에서 "java -jar " 까지 입력합니다. 마지막에 한칸 띄워져 있어야 해요.
8. Finder 의 CHEF.jar 를 터미널에 드래그 앤 드랍 해줍니다.
9. 그러면 java -jar /Users/{여러분이 지정한 ID}/Downloads/CHEF.jar 라고 될 것입니다. 맞다면 엔터를 눌러주세요.
10. Enjoy CHEF!

### Java 가 설치된 환경에서 CHEF.jar 로 실행하기 (숙련자 용)
- Java 가 설치되지 않았다면, 윗단계를 먼저 해 주세요.
- [CHEF Jar 다운로드](https://github.com/minisv/CHEF/raw/refs/heads/main/download/CHEF.jar) 받기
- 이곳에서 받지 않은 파일은 '악성코드' 에 감염되어 있을 수 있으니 조심하여 주세요.
~~~
java -jar CHEF.jar
~~~
- 위의 명령어를 입력하면 실행이 됩니다. (물론 이 설명은 숙련자 용 이니까 올바른 CHEF.jar 위치에서 명령을 실행해야 합니다.)
- 다만, java 환경설정이 되어 있어야 합니다.

### 사용방법
1. 보이스 팩 타입을 골라주세요.
2. 녹음한 파일 타입을 골라주세요. ogg 와 mp3 를 지원합니다.
3. 보이스팩 폴더를 선택해주세요. 버튼을 눌러 폴더를 지정해 주세요.
4. 파일 체크를 시작 합니다! 버튼을 누르면 파일 검사를 시작합니다.
- [DBM](https://github.com/DeadlyBossMods/DeadlyBossMods) 의 경우 [VoiceText](https://raw.githubusercontent.com/DeadlyBossMods/DBM-Voicepack-Demo/refs/heads/master/DBM-VPDemo/!VoiceText.txt) 파일을 가져와 데이터를 비교합니다.
- [BigWigs](https://github.com/BigWigsMods/BigWigs) 의 경우 [BigWigs_Voice/Tools](https://github.com/BigWigsMods/BigWigs_Voice/tree/master/Tools) 의 txt 파일들중 encode.txt 와 generate.txt 파일을 제외한 txt 파일들로 비교합니다.
- BigWigs 시즌의 경우, 시즌별 읽어오는 파일이 다를 수 있습니다. 항상 [World of Warcraft](https://worldofwarcraft.blizzard.com/) 시즌에 맞게 업데이트 될 예정입니다.

### 궁금한점은?
- 디스코드 minirune 으로 친구요청 하시고 문의 하여 주시기 바랍니다.
- 친구요청 하실때엔 방송채널 (치지직, 유튜브, 트위치 관계 없습니다.) 링크도 함께 보내주시면 더 좋겠습니다.

### 마무리 글
항상 [World of Warcraft](https://worldofwarcraft.blizzard.com/) 유저 분들을 위해 보이스 팩을 녹음 해주시는 분들의 노고에 감사 드립니다.