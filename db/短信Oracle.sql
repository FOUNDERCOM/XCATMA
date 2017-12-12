--------------------------------------------

spool Oracle.log

prompt
prompt Creating table BADOUTBOX
prompt ========================
prompt
create table BADOUTBOX
(
  ID               NUMBER not null,
  EXPRESSLEVEL     NUMBER,
  SENDER           VARCHAR2(50),
  RECEIVERMOBILENO VARCHAR2(50),
  MSG              VARCHAR2(500),
  SENDTIME         DATE,
  NEEDREPORT       NUMBER,
  ISCHINESE        NUMBER
);
alter table BADOUTBOX
  add constraint BADOUTBOX_PK11075707620945 primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INBOX
prompt ====================
prompt
create table INBOX
(
  ID          NUMBER not null,
  SENDER      VARCHAR2(50),
  MSG         VARCHAR2(500),
  COMMPORT    NUMBER,
  ARRIVEDTIME DATE
);
alter table INBOX
  add constraint INBOX_PK21075710238559 primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OUTBOX
prompt =====================
prompt
create table OUTBOX
(
  ID               NUMBER not null,
  EXPRESSLEVEL     NUMBER default 2 not null,
  SENDER           VARCHAR2(50),
  RECEIVERMOBILENO VARCHAR2(50) not null,
  MSG              VARCHAR2(500),
  SENDTIME         DATE default SYSDATE not null ,
  NEEDREPORT       NUMBER default 0 not null,
  COMMPORT         NUMBER default 0 not null,
  ISCHINESE        NUMBER default 1 not null
);
alter table OUTBOX
  add constraint OUTBOX_PK21075710226041 primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SENDEDOUTBOX
prompt ===========================
prompt
create table SENDEDOUTBOX
(
  ID               NUMBER not null,
  EXPRESSLEVEL     NUMBER,
  SENDER           VARCHAR2(50),
  RECEIVERMOBILENO VARCHAR2(50),
  MSG              VARCHAR2(500),
  SENDTIME         DATE,
  ISCHINESE        NUMBER,
  MSGREFERENCE     NUMBER,
  NEEDREPORT       NUMBER,
  COMMPORT         NUMBER
);
alter table SENDEDOUTBOX
  add primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );




prompt
prompt Creating table STATUSREPORT
prompt ===========================
prompt
create table STATUSREPORT
(
  ID               NUMBER not null,
  MSGREFERENCE     NUMBER,
  RECEIVER         VARCHAR2(50),
  ORIGINSENDTIME   DATE,
  ARRIVEDTIME      DATE,
  COMMPORT         NUMBER
);
alter table STATUSREPORT
  add primary key (ID)
  using index 
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



prompt
prompt Creating sequence BADOUTBOX_ID_SEQ
prompt ==================================
prompt
create sequence BADOUTBOX_ID_SEQ
minvalue 1
maxvalue 999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence INBOX_ID_SEQ
prompt ==============================
prompt
create sequence INBOX_ID_SEQ
minvalue 1
maxvalue 999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence OUTBOX_ID_SEQ
prompt ===============================
prompt
create sequence OUTBOX_ID_SEQ
minvalue 1
maxvalue 999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence SENDEDOUTBOX_ID_SEQ
prompt =====================================
prompt
create sequence SENDEDOUTBOX_ID_SEQ
minvalue 1
maxvalue 999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence STATUSREPORT_ID_SEQ
prompt =====================================
prompt
create sequence STATUSREPORT_ID_SEQ
minvalue 1
maxvalue 999999999
start with 81
increment by 1
cache 20;


prompt
prompt Creating trigger SET_BADOUTBOX_ID
prompt =================================
prompt
CREATE OR REPLACE TRIGGER "SET_BADOUTBOX_ID" BEFORE INSERT
    ON "BADOUTBOX"
    FOR EACH ROW

DECLARE
  NEXT_BADOUTBOX_ID NUMBER;
BEGIN
  SELECT BADOUTBOX_ID_SEQ.NEXTVAL INTO NEXT_BADOUTBOX_ID FROM DUAL;
  :NEW.ID := NEXT_BADOUTBOX_ID;
END;
/

prompt
prompt Creating trigger SET_INBOX_ID
prompt =============================
prompt
CREATE OR REPLACE TRIGGER "SET_INBOX_ID" BEFORE INSERT
    ON "INBOX"
    FOR EACH ROW

DECLARE
  NEXT_INBOX_ID NUMBER;
BEGIN
  SELECT INBOX_ID_SEQ.NEXTVAL INTO NEXT_INBOX_ID FROM DUAL;
  :NEW.ID := NEXT_INBOX_ID;
END;
/

prompt
prompt Creating trigger SET_OUTBOX_ID
prompt ==============================
prompt
CREATE OR REPLACE TRIGGER "SET_OUTBOX_ID" BEFORE
    INSERT  ON "OUTBOX"
FOR EACH ROW

DECLARE
  NEXT_OUTBOX_ID NUMBER;
BEGIN
  SELECT OUTBOX_ID_SEQ.NEXTVAL INTO NEXT_OUTBOX_ID FROM DUAL;
  :NEW.ID := NEXT_OUTBOX_ID;
END;
/

prompt
prompt Creating trigger SET_SENDEDOUTBOX_ID
prompt ====================================
prompt
CREATE OR REPLACE TRIGGER "SET_SENDEDOUTBOX_ID" BEFORE
    INSERT  ON "SENDEDOUTBOX"
FOR EACH ROW

DECLARE
  NEXT_SENDEDOUTBOX_ID NUMBER;
BEGIN
  SELECT SENDEDOUTBOX_ID_SEQ.NEXTVAL INTO NEXT_SENDEDOUTBOX_ID FROM DUAL;
  :NEW.ID := NEXT_SENDEDOUTBOX_ID;
END;
/

prompt
prompt Creating trigger SET_STATUSREPORT_ID
prompt ====================================
prompt
CREATE OR REPLACE TRIGGER "SET_STATUSREPORT_ID" BEFORE
    INSERT  ON "STATUSREPORT"
FOR EACH ROW

DECLARE
  NEXT_STATUSREPORT_ID NUMBER;
BEGIN
  SELECT STATUSREPORT_ID_SEQ.NEXTVAL INTO NEXT_STATUSREPORT_ID FROM DUAL;
  :NEW.ID := NEXT_STATUSREPORT_ID;
END;
/

commit;
spool off
