# wms-3355ABC
#  [신발 종합 쇼핑몰 본사 창고 관리 프로그램]

## 👠 프로젝트 소개 👠
* 개발기간 : 2024.05.16 - 2024.05.21 (일)
* 각 가맹점의 재고 요청을 받아들이고 필요한 재고를 본사에서 출고 처리하는 시스템입니다.
  전체 주문 데이터를 확인하여 상품별 매출, 가맹점별 매출 등 다양한 카테고리를 기준으로 분석할 수 있습니다.

## 🧑‍💻팀원 구성

1.  연주현 (DISNOTACAT)
2.  고유진 (yujin4sth00)
3.  김성호 (OOOIOOOIO)
4.  서윤정 (yj0318)
5.  좌상현 (sanghyeonJwa)
6.  김민규 (Gyunorld)

## 🛠️개발 환경
* Develop : JAVA17 , MYSQL8 , MYBatis , Gradle , Intellij
* Version Constrol : Git
* Communicate : Slack, Figjam, Notion

## 프로젝트 구조
```
├─.gradle
│  ├─8.4
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
├─build
│  ├─classes
│  │  └─java
│  │      └─main
│  │          └─com
│  │              └─abc3355
│  │                  └─abc_wms_system
│  │                      ├─common
│  │                      ├─orderForm
│  │                      │  ├─controller
│  │                      │  ├─model
│  │                      │  │  ├─dao
│  │                      │  │  ├─dto
│  │                      │  │  └─service
│  │                      │  └─view
│  │                      ├─orderProcess
│  │                      │  ├─controller
│  │                      │  ├─model
│  │                      │  │  ├─dao
│  │                      │  │  ├─dto
│  │                      │  │  └─service
│  │                      │  └─view
│  │                      ├─Product
│  │                      │  ├─controller
│  │                      │  ├─model
│  │                      │  │  ├─dao
│  │                      │  │  ├─dto
│  │                      │  │  └─service
│  │                      │  └─view
│  │                      ├─run
│  │                      ├─salesManager
│  │                      │  ├─controller
│  │                      │  ├─model
│  │                      │  │  ├─dao
│  │                      │  │  ├─dto
│  │                      │  │  └─service
│  │                      │  └─View
│  │                      ├─searchProduct
│  │                      │  ├─controller
│  │                      │  ├─model
│  │                      │  │  ├─dao
│  │                      │  │  ├─dto
│  │                      │  │  └─service
│  │                      │  └─view
│  │                      └─user
│  │                          ├─controller
│  │                          ├─model
│  │                          │  ├─dao
│  │                          │  │  └─UserInsert
│  │                          │  └─dto
│  │                          ├─service
│  │                          └─view
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      └─main
│  │      └─headers
│  │          └─java
│  │              └─main
│  ├─resources
│  │  └─main
│  │      └─sql
│  │          ├─orderForm
│  │          ├─orderProcess
│  │          ├─product
│  │          ├─salesManager
│  │          ├─searchProduct
│  │          └─userLogin
│  └─tmp
│      └─compileJava
├─gradle
│  └─wrapper
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─abc3355
    │  │          └─abc_wms_system
    │  │              ├─common
    │  │              ├─orderForm
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  ├─dao
    │  │              │  │  ├─dto
    │  │              │  │  └─service
    │  │              │  └─view
    │  │              ├─orderProcess
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  ├─dao
    │  │              │  │  ├─dto
    │  │              │  │  └─service
    │  │              │  └─view
    │  │              ├─Product
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  ├─dao
    │  │              │  │  ├─dto
    │  │              │  │  └─service
    │  │              │  └─view
    │  │              ├─run
    │  │              ├─salesManager
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  ├─dao
    │  │              │  │  ├─dto
    │  │              │  │  └─service
    │  │              │  └─View
    │  │              ├─searchProduct
    │  │              │  ├─controller
    │  │              │  ├─model
    │  │              │  │  ├─dao
    │  │              │  │  ├─dto
    │  │              │  │  └─service
    │  │              │  └─view
    │  │              └─user
    │  │                  ├─controller
    │  │                  ├─model
    │  │                  │  ├─dao
    │  │                  │  │  └─UserInsert
    │  │                  │  └─dto
    │  │                  ├─service
    │  │                  └─view
    │  └─resources
    │      └─sql
    │          ├─orderForm
    │          ├─orderProcess
    │          ├─product
    │          ├─salesManager
    │          ├─searchProduct
    │          └─userLogin
    └─test
        └─java
            └─com
                └─abc3355
                    └─abc_wms_system
                        ├─orderForm
                        │  └─mapper
                        ├─orderProcess
                        │  └─mapper
                        └─product
                            └─mapper
```
<br>

## 📋역할 분담
####  고유진
  * 가맹점 
      * 로그인(코드방식)
  * 본사
    * 로그인 
    * 가맹점 등록
    * 가맹점 삭제

#### 김민규
  * 상품 조회 관련
  
    * 상품 전체 조회
    * 상품 상세 조회
    * 품절 상품 조회
    * 재고 조회
    *  전체 재고 확인 
    * 상세 재고 확인

#### 서윤정
  * 가맹점
    * 로그인 (계정 방식)
  * 주문서 작성
    * 주문서 작성하기
    * 주문 상품 리스트 
    * 주문서 발송

#### 좌상현
  * 주문 관리
    * 주문내역 처리
    * 주문 처리
    * 주문 수정
    * 주문 삭제


#### 김성호
  
  * 상품 관리
  
    * 상품등록
    * 상품 수정
    * 상품 삭제
    * 입고 기록 등록
    * 입고 기록 조회


#### 연주현
  * 매출 관리
    * 가맹점별 주문 조회
    * 전체 출고량 조회
    * 상품별 출고량 조회
  


## 📕 프로젝트 후기

### 서윤정

    MYSQL과 JAVA를 연동해서 하는 프로젝트는 처음이여서 그런지 어려운 점이 많았다. 
    개인적으로 이번 프로젝트를 하면서 아쉬었던 점은 구조에 대한 이해가 적었고 MYBatis에 대한 이해도가 낮았다.
    다음 프로젝트 때는 더 구조를 명확하게 이해 하고 명세화 해야 겠다. 

### 연주현


### 고유진


### 김성호


### 좌상현



### 김민규

    이전의 프로젝트들과 달리 DATA를 사용한 프로젝트였는데 DATA에 대한 많은 이해가 필요했다.
    JAVA로 코드를 구성하는 것은 이전의 프로젝트보다 수월했지만 새롭게 사용한 MyBatis에서 어려움을 많이 겪었다.
    특히 쿼리문은 오류를 찾기가 어려워서 문제가 생겼을 때 인지하고 수정하는데 오랜 시간이 걸렸다.
    그래도 이번 경험을 통해서 쿼리문의 작성에 대한 많은 배움을 얻었다. 
    그리고 브랜치를 만들어서 작업했는데 깃의 조작에는 어려움이 있었지만 작업의 편의성은 크게 개선되었다.
