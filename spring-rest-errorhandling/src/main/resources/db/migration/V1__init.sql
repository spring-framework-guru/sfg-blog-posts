;              
CREATE USER IF NOT EXISTS "SA" SALT 'bbf41cfe93fd77ff' HASH 'ffc3d378ff0b46fdfbd30e364cc9cd13147657c237e1bfb290ac6e0778509014' ADMIN;          
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_5896329F_6198_45EE_B643_75510917F179" START WITH 1 BELONGS_TO_TABLE; 
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_4C89E7A2_EAA9_4D3B_A0F2_478ADAE750A9" START WITH 1 BELONGS_TO_TABLE; 

CREATE CACHED TABLE "PUBLIC"."TBL_PETS"(
    "ID" INTEGER DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_5896329F_6198_45EE_B643_75510917F179") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_5896329F_6198_45EE_B643_75510917F179",
    "BIRTH_DATE" DATE,
    "NAME" VARCHAR(255),
    "TYPE_ID" INTEGER
); 
ALTER TABLE "PUBLIC"."TBL_PETS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("ID");      
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TBL_PETS; 

CREATE CACHED TABLE "PUBLIC"."TBL_TYPES"(
    "ID" INTEGER DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_4C89E7A2_EAA9_4D3B_A0F2_478ADAE750A9") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_4C89E7A2_EAA9_4D3B_A0F2_478ADAE750A9",
    "NAME" VARCHAR(255)
);              
ALTER TABLE "PUBLIC"."TBL_TYPES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");     
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TBL_TYPES;
ALTER TABLE "PUBLIC"."TBL_PETS" ADD CONSTRAINT "PUBLIC"."UK_G3QXFT89OQ7HI0MBN42JNTH60" UNIQUE("NAME");         
ALTER TABLE "PUBLIC"."TBL_PETS" ADD CONSTRAINT "PUBLIC"."FK22GRKEMC6N0JN42LHBASHD8XX" FOREIGN KEY("TYPE_ID") REFERENCES "PUBLIC"."TBL_TYPES"("ID") NOCHECK;    
