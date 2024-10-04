<br><br>
<p align="center">
  <img src="https://github.com/user-attachments/assets/13f90774-651b-4d47-a640-f0dc8c6d254e" width="500">
</p>

<br>

## :coffee: 주요 기능

* 다국어 지원
* Light / Dark Theme 지원
* Portrait / LandScape 화면 모드 지원
* Toolbar를 이용해 화면 타이틀 표시 및 뒤로가기 구현
* 직접 제작한 Lottie Animaton
 

## :bagel: 살펴보기

<table align="center">
<thead>
  <tr margin-bottom=3px>
    <td align="center">
      <b>로그인 화면<b>
    </td>
    <td align="center">
      <b>회원가입 화면</b>
    </td>
    <td align="center">
      <b>홈 화면</b>
    </td>
  </tr>
</thead>
<tbody>
<tr>
  <td  align="center">
    <img src="https://github.com/user-attachments/assets/4e4b180b-99f7-49ce-9b31-1738197ac743" width="200">
  </td>
  <td align="center">
    <img src="https://github.com/user-attachments/assets/fe9b9beb-eae5-4b29-9c2e-2e9f37eee747" width="200">
  </td>
  <td align="center">
    <img src="https://github.com/user-attachments/assets/0333243d-37f3-4f3d-8499-81fa067c9f9a" width="200">
  </td>
</tr>

<tr>
  <td  align="center">
    <b>마이페이지 화면</b>
  </td>
  <td align="center">
    <b>메뉴 상세 화면</b>
  </td>
  <td align="center">
    <b>  </b>
  </td>
</tr>

<tr>
  <td  align="center">
    <img src="https://github.com/user-attachments/assets/79cdf48b-f19b-46e6-b6fb-d2ecb8627f9a" width="200"  > 
  </td>
  <td  align="center">
    <img src="https://github.com/user-attachments/assets/c3094c08-8006-4793-a4c9-71459556b7ae" width="200" >
  </td>
  <td  align="center">
  </td>
</tr>
</tbody>
</table>

<br><br>
<h3 style="color:#6C6053" align="center">:bread: 로그인</h3>
<br>

<p align="center">
<img src="https://github.com/user-attachments/assets/4e4b180b-99f7-49ce-9b31-1738197ac743" width="200" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/21c02db8-930d-4d36-96f4-cde026410da7" width="200" />
</p>

* User Data 관리
  - User 인스턴스에 HashMap 형태로 저장
  - User 클래스는 Parcelable 상속 
* UserData 받아오기
  - 회원가입 직후 회원가입 화면에서 UserData를 전달 받아 HashMap에 저장 
* configChanges 관리
  - 화면 방향 전환 시 재시작 되어 회원가입 정보가 날아가는 현상을 방지 

<br><br>
<h3 style="color:#6C6053" align="center">:waffle: 회원가입</h3>
<br>

<p align="center">
<img src="https://github.com/user-attachments/assets/fe9b9beb-eae5-4b29-9c2e-2e9f37eee747" width="200" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/0a115f33-8802-4b76-9d80-ba25272cbdf4" width="200" />
</p>

* Toolbar
  - 상단 타이틀 표시와 뒤로가기 구현
* 유효성 검사
  - Regex를 이용하여 정규표현식을 작성하고 matches() 함수로 유효성 검사
* 아이디 중복 체크
  - 로그인 화면에서 받아온 id의 key 값을 비교하여 중복 체크
  - 아이디를 중복체크 한 뒤 아이디 값을 바꿀 경우 다시 체크할 수 있도록 Listener 추가


<br><br>
<h3 style="color:#6C6053" align="center">:croissant: 홈 화면</h3>
<br>

<p align="center">
<img src="https://github.com/user-attachments/assets/0333243d-37f3-4f3d-8499-81fa067c9f9a" width="200" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/07692471-cfa1-4d20-9b22-a7a41312b7b4" width="200" />
</p>

* 2개의 ScrollView 사용
  - 서로 다른 두 ScrollView를 동시에 처리
  - 화면 방향이 전환될 때 id 값을 다르게 지정함으로서 에러 해결
* 카페 메뉴 순서 랜덤 노출
  - 여러 메뉴들을 랜덤으로 노출하고 랜덤 값에 따른 상세 페이지로 연결될 수 있도록 처리
* 원형 ImageView 처리
  - drawble 폴더에 background 생성 후 처리
* 더보기 활성화
  - TextViw가 긴 경우 ellipsize 처리 후 더보기 버튼을 눌러 전문 공개
* UserData 관리
  - 로그인할 때 받아온 UserData를 사용하고 이를 다시 마이페이지로 전달

<br><br>
<h3 style="color:#6C6053" align="center">:pancakes: 마이페이지</h3>
<br>

<p align="center">
<img src="https://github.com/user-attachments/assets/79cdf48b-f19b-46e6-b6fb-d2ecb8627f9a" width="200" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/3a485756-c266-494f-aacc-8cfb6c144567" width="200" />
</p>

* 원형 ImageView 처리
  - drawble 폴더에 background 생성 후 처리
* 반응형 디자인 적용
  - 메뉴 이름이 길어질 경우 사용자 이름과 작성 날짜가 메뉴 아래에 오도록 구현
* 더보기 활성화
  - TextView가 길어지는 경우 레이아웃에 맞게 줄어들고 더보기 버튼을 눌러 전문 공개
* Menu Class 전역 관리
  - Menu 클래스는 Parcelable을 상속받아 전역으로 관리할 수 있게 처리

<br><br>
<h3 style="color:#6C6053" align="center">:pretzel: 상세 화면</h3>
<br>

<p align="center">
<img src="https://github.com/user-attachments/assets/c3094c08-8006-4793-a4c9-71459556b7ae" width="200" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://github.com/user-attachments/assets/723b5cc3-bdc5-407f-a707-4bbb2490abce" width="200" />
</p>

* 원형 ImageView 처리
  - drawble 폴더에 background 생성 후 처리
* UserData 관리
  - Intent를 통해 홈 화면에서 UserData를 받아와 사용자 정보를 노출
* 사용자 프로필 랜덤 노출
  - 사용자의 프로필 사진만 모아놓은 list를 shuffled()를 사용해 랜덤 노출되도록 구현
* 더보기 활성화
  - Text가 한 줄 이상일 경우 ellipsize를 처리하고, 텍스트를 클릭하면 maxLine이 최대 5줄까지 노출 될 수 있도록 처리
* 메뉴 랜덤 노출
  - 메뉴 정보를 담은 string-array의 데이터를 랜덤으로 뽑아 하나 이상의 메뉴가 보이도록 구현
* 네이버 지도로 연결
  - 암묵적 인텐트를 이용해 카페 지도를 크롬 화면으로 연결할 수 있도록 처리


## :busts_in_silhouette: 팀원

<table align="center">
  <thead>
    <tr margin-bottom=3px>
    <td align="center">
     <a href="https://github.com/ImGaram"><b style="color:#6C6053">임가람 (리더)<b></a>
    </td>
    <td align="center">
     <a href="https://github.com/kkevi"><b style="color:#A79C8A">김보라<b></a>
    </td>
    <td align="center">
     <a href="https://github.com/overtae"><b style="color:#A79C8A">김태영<b></a>
    </td>
    <td align="center">
     <a href="https://github.com/wjsghk7664"><b style="color:#A79C8A">송유호<b></a>
    </td>
    </tr>
  </thead>
  
  <tbody>
  <tr>
  <td  align="center">
    <img src="https://avatars.githubusercontent.com/u/84944117?v=4" width="100">
  </td>
  <td align="center">
    <img src="https://avatars.githubusercontent.com/u/77606317?v=4" width="100">
  </td>
  <td  align="center">
    <img src="https://avatars.githubusercontent.com/u/51291185?v=4" width="100">
  </td>
  <td align="center">
    <img src="https://github.com/user-attachments/assets/b07e6047-1553-4a4d-9cab-1ac5aeeedd22" width="100">
  </td>
  </tr>
  <tr>
  <td  align="center">
    <ul>
      <li>Git 프로젝트 생성</li>
      <li>Figma 와이어 프레임 작업</li>
      <li>마이페이지 구현</li>
    </ul>
  </td>
  <td align="center">
    <ul>
      <li>Figma 와이어 프레임 작업</li>
      <li>홈 화면 구현</li>
      <li>발표 자료 제작</li>
    </ul>
  </td>
  <td  align="center">
    <ul>
      <li>Figma 와이어 프레임 작업</li>
      <li>상세 화면 구현</li>
      <li>Github Readme 작성</li>
    </ul>
  </td>
  <td align="center">
    <ul>
      <li>Figma 와이어 프레임 작업</li>
      <li>로그인 화면 구현</li>
      <li>회원가입 화면 구현</li>
    </ul>
  </td>
  </tr>
</tbody>
</table>

## :wrench: 기술 스택

<p>
<img height="50" width="50" src="https://cdn.simpleicons.org/kotlin/7F52FF" />
<img height="50" width="50" src="https://cdn.simpleicons.org/git/F05032" />
<img height="50" width="50" src="https://cdn.simpleicons.org/gradle/02303A" />
</p>

## :computer: 개발/협업 환경

<p>
<img height="50" width="50" src="https://cdn.simpleicons.org/androidstudio/3DDC84" />
<img height="50" width="50" src="https://cdn.simpleicons.org/notion/000000" />
<img height="50" width="50" src="https://cdn.simpleicons.org/github/181717" />
<img height="50" width="50" src="https://cdn.simpleicons.org/slack/4A154B" />
</p>
