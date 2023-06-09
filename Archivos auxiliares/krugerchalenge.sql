PGDMP     6    9                {            krugerchallenge    14.5    14.5 -               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    65668    krugerchallenge    DATABASE     m   CREATE DATABASE krugerchallenge WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Bolivia.1252';
    DROP DATABASE krugerchallenge;
                postgres    false                        2615    65670 	   inventory    SCHEMA        CREATE SCHEMA inventory;
    DROP SCHEMA inventory;
                postgres    false                        2615    65669    usuario    SCHEMA        CREATE SCHEMA usuario;
    DROP SCHEMA usuario;
                postgres    false            �            1259    65680    vaccination    TABLE     /  CREATE TABLE inventory.vaccination (
    id integer NOT NULL,
    date date,
    doses integer,
    id_user integer,
    created_by character varying,
    created_date timestamp without time zone,
    updated_by character varying,
    updated_date timestamp without time zone,
    id_vaccine integer
);
 "   DROP TABLE inventory.vaccination;
    	   inventory         heap    postgres    false    5            �            1259    65720    vaccination_id_seq    SEQUENCE     �   CREATE SEQUENCE inventory.vaccination_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE inventory.vaccination_id_seq;
    	   inventory          postgres    false    5    212                        0    0    vaccination_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE inventory.vaccination_id_seq OWNED BY inventory.vaccination.id;
       	   inventory          postgres    false    216            �            1259    65737    vaccine    TABLE     �   CREATE TABLE inventory.vaccine (
    id integer NOT NULL,
    name character varying,
    created_by character varying,
    created_date timestamp without time zone,
    updated_by character varying,
    updated_date timestamp without time zone
);
    DROP TABLE inventory.vaccine;
    	   inventory         heap    postgres    false    5            �            1259    65736    vacinne_id_seq    SEQUENCE     �   CREATE SEQUENCE inventory.vacinne_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE inventory.vacinne_id_seq;
    	   inventory          postgres    false    218    5            !           0    0    vacinne_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE inventory.vacinne_id_seq OWNED BY inventory.vaccine.id;
       	   inventory          postgres    false    217            �            1259    65761    config    TABLE     V  CREATE TABLE usuario.config (
    id integer NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(250),
    enabled boolean,
    id_user integer,
    created_by character varying,
    created_date timestamp without time zone,
    updated_by character varying,
    updated_date timestamp without time zone
);
    DROP TABLE usuario.config;
       usuario         heap    postgres    false    6            �            1259    65760    config_id_seq    SEQUENCE     �   CREATE SEQUENCE usuario.config_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE usuario.config_id_seq;
       usuario          postgres    false    6    220            "           0    0    config_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE usuario.config_id_seq OWNED BY usuario.config.id;
          usuario          postgres    false    219            �            1259    65684    rol    TABLE     �   CREATE TABLE usuario.rol (
    id integer NOT NULL,
    name character varying,
    created_by character varying,
    created_date timestamp without time zone,
    updated_by character varying,
    updated_date timestamp without time zone
);
    DROP TABLE usuario.rol;
       usuario         heap    postgres    false    6            �            1259    65683 
   rol_id_seq    SEQUENCE     �   CREATE SEQUENCE usuario.rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE usuario.rol_id_seq;
       usuario          postgres    false    6    214            #           0    0 
   rol_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE usuario.rol_id_seq OWNED BY usuario.rol.id;
          usuario          postgres    false    213            �            1259    65674    user    TABLE     �  CREATE TABLE usuario."user" (
    id integer NOT NULL,
    name character varying NOT NULL,
    last_name character varying NOT NULL,
    ci integer NOT NULL,
    email character varying(100) NOT NULL,
    birthdate date,
    phone integer,
    vaccinated boolean,
    created_by character varying,
    created_date timestamp without time zone,
    updated_by character varying,
    updated_date timestamp without time zone,
    id_rol integer
);
    DROP TABLE usuario."user";
       usuario         heap    postgres    false    6            �            1259    65692    user_id_seq    SEQUENCE     �   CREATE SEQUENCE usuario.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE usuario.user_id_seq;
       usuario          postgres    false    211    6            $           0    0    user_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE usuario.user_id_seq OWNED BY usuario."user".id;
          usuario          postgres    false    215            s           2604    65721    vaccination id    DEFAULT     v   ALTER TABLE ONLY inventory.vaccination ALTER COLUMN id SET DEFAULT nextval('inventory.vaccination_id_seq'::regclass);
 @   ALTER TABLE inventory.vaccination ALTER COLUMN id DROP DEFAULT;
    	   inventory          postgres    false    216    212            u           2604    65740 
   vaccine id    DEFAULT     n   ALTER TABLE ONLY inventory.vaccine ALTER COLUMN id SET DEFAULT nextval('inventory.vacinne_id_seq'::regclass);
 <   ALTER TABLE inventory.vaccine ALTER COLUMN id DROP DEFAULT;
    	   inventory          postgres    false    218    217    218            v           2604    65764 	   config id    DEFAULT     h   ALTER TABLE ONLY usuario.config ALTER COLUMN id SET DEFAULT nextval('usuario.config_id_seq'::regclass);
 9   ALTER TABLE usuario.config ALTER COLUMN id DROP DEFAULT;
       usuario          postgres    false    220    219    220            t           2604    65687    rol id    DEFAULT     b   ALTER TABLE ONLY usuario.rol ALTER COLUMN id SET DEFAULT nextval('usuario.rol_id_seq'::regclass);
 6   ALTER TABLE usuario.rol ALTER COLUMN id DROP DEFAULT;
       usuario          postgres    false    213    214    214            r           2604    65693    user id    DEFAULT     f   ALTER TABLE ONLY usuario."user" ALTER COLUMN id SET DEFAULT nextval('usuario.user_id_seq'::regclass);
 9   ALTER TABLE usuario."user" ALTER COLUMN id DROP DEFAULT;
       usuario          postgres    false    215    211                      0    65680    vaccination 
   TABLE DATA           �   COPY inventory.vaccination (id, date, doses, id_user, created_by, created_date, updated_by, updated_date, id_vaccine) FROM stdin;
 	   inventory          postgres    false    212   A4                 0    65737    vaccine 
   TABLE DATA           b   COPY inventory.vaccine (id, name, created_by, created_date, updated_by, updated_date) FROM stdin;
 	   inventory          postgres    false    218   �4                 0    65761    config 
   TABLE DATA              COPY usuario.config (id, username, password, enabled, id_user, created_by, created_date, updated_by, updated_date) FROM stdin;
    usuario          postgres    false    220   �4                 0    65684    rol 
   TABLE DATA           \   COPY usuario.rol (id, name, created_by, created_date, updated_by, updated_date) FROM stdin;
    usuario          postgres    false    214   E5                 0    65674    user 
   TABLE DATA           �   COPY usuario."user" (id, name, last_name, ci, email, birthdate, phone, vaccinated, created_by, created_date, updated_by, updated_date, id_rol) FROM stdin;
    usuario          postgres    false    211   �5       %           0    0    vaccination_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('inventory.vaccination_id_seq', 32, true);
       	   inventory          postgres    false    216            &           0    0    vacinne_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('inventory.vacinne_id_seq', 9, true);
       	   inventory          postgres    false    217            '           0    0    config_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('usuario.config_id_seq', 8, true);
          usuario          postgres    false    219            (           0    0 
   rol_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('usuario.rol_id_seq', 6, true);
          usuario          postgres    false    213            )           0    0    user_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('usuario.user_id_seq', 23, true);
          usuario          postgres    false    215            z           2606    65735    vaccination vaccination_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY inventory.vaccination
    ADD CONSTRAINT vaccination_pkey PRIMARY KEY (id);
 I   ALTER TABLE ONLY inventory.vaccination DROP CONSTRAINT vaccination_pkey;
    	   inventory            postgres    false    212            ~           2606    65744    vaccine vacinne_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY inventory.vaccine
    ADD CONSTRAINT vacinne_pkey PRIMARY KEY (id);
 A   ALTER TABLE ONLY inventory.vaccine DROP CONSTRAINT vacinne_pkey;
    	   inventory            postgres    false    218            �           2606    65768    config config_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY usuario.config
    ADD CONSTRAINT config_pkey PRIMARY KEY (id);
 =   ALTER TABLE ONLY usuario.config DROP CONSTRAINT config_pkey;
       usuario            postgres    false    220            |           2606    65691    rol rol_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY usuario.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);
 7   ALTER TABLE ONLY usuario.rol DROP CONSTRAINT rol_pkey;
       usuario            postgres    false    214            x           2606    65700    user user_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY usuario."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 ;   ALTER TABLE ONLY usuario."user" DROP CONSTRAINT user_pkey;
       usuario            postgres    false    211            �           2606    65750 $   vaccination vaccination_id_user_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY inventory.vaccination
    ADD CONSTRAINT vaccination_id_user_fkey FOREIGN KEY (id_user) REFERENCES usuario."user"(id) NOT VALID;
 Q   ALTER TABLE ONLY inventory.vaccination DROP CONSTRAINT vaccination_id_user_fkey;
    	   inventory          postgres    false    211    3192    212            �           2606    65755 '   vaccination vaccination_id_vaccine_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY inventory.vaccination
    ADD CONSTRAINT vaccination_id_vaccine_fkey FOREIGN KEY (id_vaccine) REFERENCES inventory.vaccine(id) NOT VALID;
 T   ALTER TABLE ONLY inventory.vaccination DROP CONSTRAINT vaccination_id_vaccine_fkey;
    	   inventory          postgres    false    218    3198    212            �           2606    65769    config config_id_user_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY usuario.config
    ADD CONSTRAINT config_id_user_fkey FOREIGN KEY (id_user) REFERENCES usuario."user"(id) NOT VALID;
 E   ALTER TABLE ONLY usuario.config DROP CONSTRAINT config_id_user_fkey;
       usuario          postgres    false    211    3192    220            �           2606    65745    user user_id_rol_fkey    FK CONSTRAINT        ALTER TABLE ONLY usuario."user"
    ADD CONSTRAINT user_id_rol_fkey FOREIGN KEY (id_rol) REFERENCES usuario.rol(id) NOT VALID;
 B   ALTER TABLE ONLY usuario."user" DROP CONSTRAINT user_id_rol_fkey;
       usuario          postgres    false    3196    214    211               8   x�36�4202�50�54�4�9c�Ȅ��Y��	FpF���
�b���� �?         <   x�3�����+�/.N���#.Δļ��AC�jT����%E�y�(��)(�=... �w�         `   x�3�LI�s	rsww�L��445.�����,�44��#.#��ԢĢ�|��R�
s����E�鹉�9z�����FƦf&@�F�(jc���� XE �         .   x�3�LL�����#.cβԜ̲�"Q�⒢̼t�=... z7{         �   x����
�@E��Iؙ}�٘��6��n$��D��MH��"����p7e��/�yo�n����s[C~	���b�ݖ$Q"UB����
�p�	w�����tc��g��-�-�C������)���'jɀ���z�?���	z�s&     