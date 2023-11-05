PGDMP  
    (            
    {         
   spautiflop    16.0 (Debian 16.0-1.pgdg120+1)    16.0 <    a           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            b           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            c           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            d           1262    16384 
   spautiflop    DATABASE     u   CREATE DATABASE spautiflop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE spautiflop;
                cytech    false            �            1259    16386    album    TABLE     �   CREATE TABLE public.album (
    id bigint NOT NULL,
    image character varying(255),
    name character varying(255) NOT NULL,
    release character varying(255),
    artist_id bigint NOT NULL
);
    DROP TABLE public.album;
       public         heap    cytech    false            �            1259    16385    album_id_seq    SEQUENCE     u   CREATE SEQUENCE public.album_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.album_id_seq;
       public          cytech    false    216            e           0    0    album_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.album_id_seq OWNED BY public.album.id;
          public          cytech    false    215            �            1259    16395    artist    TABLE     �   CREATE TABLE public.artist (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    photo character varying(255)
);
    DROP TABLE public.artist;
       public         heap    cytech    false            �            1259    16394    artist_id_seq    SEQUENCE     v   CREATE SEQUENCE public.artist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.artist_id_seq;
       public          cytech    false    218            f           0    0    artist_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.artist_id_seq OWNED BY public.artist.id;
          public          cytech    false    217            �            1259    16403    likes    TABLE     d   CREATE TABLE public.likes (
    id bigint NOT NULL,
    local_user_id bigint,
    song_id bigint
);
    DROP TABLE public.likes;
       public         heap    cytech    false            �            1259    16446 	   likes_seq    SEQUENCE     s   CREATE SEQUENCE public.likes_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.likes_seq;
       public          cytech    false            �            1259    16409 
   local_user    TABLE     �   CREATE TABLE public.local_user (
    id bigint NOT NULL,
    password character varying(1000) NOT NULL,
    photo character varying(255) NOT NULL,
    pseudo character varying(255) NOT NULL
);
    DROP TABLE public.local_user;
       public         heap    cytech    false            �            1259    16408    local_user_id_seq    SEQUENCE     z   CREATE SEQUENCE public.local_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.local_user_id_seq;
       public          cytech    false    221            g           0    0    local_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.local_user_id_seq OWNED BY public.local_user.id;
          public          cytech    false    220            �            1259    16418    playlist    TABLE     �   CREATE TABLE public.playlist (
    id bigint NOT NULL,
    image character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    user_id bigint NOT NULL
);
    DROP TABLE public.playlist;
       public         heap    cytech    false            �            1259    16417    playlist_id_seq    SEQUENCE     x   CREATE SEQUENCE public.playlist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.playlist_id_seq;
       public          cytech    false    223            h           0    0    playlist_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.playlist_id_seq OWNED BY public.playlist.id;
          public          cytech    false    222            �            1259    16426    playlist_song    TABLE     j   CREATE TABLE public.playlist_song (
    id bigint NOT NULL,
    playlist_id bigint,
    song_id bigint
);
 !   DROP TABLE public.playlist_song;
       public         heap    cytech    false            �            1259    16447    playlist_song_seq    SEQUENCE     {   CREATE SEQUENCE public.playlist_song_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.playlist_song_seq;
       public          cytech    false            �            1259    16432    song    TABLE       CREATE TABLE public.song (
    id bigint NOT NULL,
    genre character varying(255),
    image character varying(255),
    music_link character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    nb_likes bigint NOT NULL,
    album_id bigint,
    artist_id bigint
);
    DROP TABLE public.song;
       public         heap    cytech    false            �            1259    16431    song_id_seq    SEQUENCE     t   CREATE SEQUENCE public.song_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.song_id_seq;
       public          cytech    false    226            i           0    0    song_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.song_id_seq OWNED BY public.song.id;
          public          cytech    false    225            �           2604    16389    album id    DEFAULT     d   ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);
 7   ALTER TABLE public.album ALTER COLUMN id DROP DEFAULT;
       public          cytech    false    216    215    216            �           2604    16398 	   artist id    DEFAULT     f   ALTER TABLE ONLY public.artist ALTER COLUMN id SET DEFAULT nextval('public.artist_id_seq'::regclass);
 8   ALTER TABLE public.artist ALTER COLUMN id DROP DEFAULT;
       public          cytech    false    217    218    218            �           2604    16412    local_user id    DEFAULT     n   ALTER TABLE ONLY public.local_user ALTER COLUMN id SET DEFAULT nextval('public.local_user_id_seq'::regclass);
 <   ALTER TABLE public.local_user ALTER COLUMN id DROP DEFAULT;
       public          cytech    false    220    221    221            �           2604    16421    playlist id    DEFAULT     j   ALTER TABLE ONLY public.playlist ALTER COLUMN id SET DEFAULT nextval('public.playlist_id_seq'::regclass);
 :   ALTER TABLE public.playlist ALTER COLUMN id DROP DEFAULT;
       public          cytech    false    222    223    223            �           2604    16435    song id    DEFAULT     b   ALTER TABLE ONLY public.song ALTER COLUMN id SET DEFAULT nextval('public.song_id_seq'::regclass);
 6   ALTER TABLE public.song ALTER COLUMN id DROP DEFAULT;
       public          cytech    false    226    225    226            R          0    16386    album 
   TABLE DATA                 public          cytech    false    216   �@       T          0    16395    artist 
   TABLE DATA                 public          cytech    false    218   �B       U          0    16403    likes 
   TABLE DATA                 public          cytech    false    219   �C       W          0    16409 
   local_user 
   TABLE DATA                 public          cytech    false    221   [D       Y          0    16418    playlist 
   TABLE DATA                 public          cytech    false    223   E       Z          0    16426    playlist_song 
   TABLE DATA                 public          cytech    false    224   iE       \          0    16432    song 
   TABLE DATA                 public          cytech    false    226   �E       j           0    0    album_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.album_id_seq', 20, true);
          public          cytech    false    215            k           0    0    artist_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.artist_id_seq', 9, true);
          public          cytech    false    217            l           0    0 	   likes_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.likes_seq', 101, true);
          public          cytech    false    227            m           0    0    local_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.local_user_id_seq', 1, true);
          public          cytech    false    220            n           0    0    playlist_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.playlist_id_seq', 1, true);
          public          cytech    false    222            o           0    0    playlist_song_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.playlist_song_seq', 51, true);
          public          cytech    false    228            p           0    0    song_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.song_id_seq', 53, true);
          public          cytech    false    225            �           2606    16393    album album_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.album DROP CONSTRAINT album_pkey;
       public            cytech    false    216            �           2606    16402    artist artist_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.artist
    ADD CONSTRAINT artist_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.artist DROP CONSTRAINT artist_pkey;
       public            cytech    false    218            �           2606    16407    likes likes_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.likes
    ADD CONSTRAINT likes_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.likes DROP CONSTRAINT likes_pkey;
       public            cytech    false    219            �           2606    16416    local_user local_user_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.local_user
    ADD CONSTRAINT local_user_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.local_user DROP CONSTRAINT local_user_pkey;
       public            cytech    false    221            �           2606    16425    playlist playlist_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.playlist DROP CONSTRAINT playlist_pkey;
       public            cytech    false    223            �           2606    16430     playlist_song playlist_song_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.playlist_song
    ADD CONSTRAINT playlist_song_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.playlist_song DROP CONSTRAINT playlist_song_pkey;
       public            cytech    false    224            �           2606    16439    song song_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.song
    ADD CONSTRAINT song_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.song DROP CONSTRAINT song_pkey;
       public            cytech    false    226            �           2606    16443 '   local_user uk_29clp9ilw1eslbtgdnm9d5vwa 
   CONSTRAINT     d   ALTER TABLE ONLY public.local_user
    ADD CONSTRAINT uk_29clp9ilw1eslbtgdnm9d5vwa UNIQUE (pseudo);
 Q   ALTER TABLE ONLY public.local_user DROP CONSTRAINT uk_29clp9ilw1eslbtgdnm9d5vwa;
       public            cytech    false    221            �           2606    16445 !   song uk_4b9skxyi4nggvr7ekjo5fev4o 
   CONSTRAINT     b   ALTER TABLE ONLY public.song
    ADD CONSTRAINT uk_4b9skxyi4nggvr7ekjo5fev4o UNIQUE (music_link);
 K   ALTER TABLE ONLY public.song DROP CONSTRAINT uk_4b9skxyi4nggvr7ekjo5fev4o;
       public            cytech    false    226            �           2606    16441 #   artist uk_r03a96lqhsb7djq2tn4rq60vn 
   CONSTRAINT     ^   ALTER TABLE ONLY public.artist
    ADD CONSTRAINT uk_r03a96lqhsb7djq2tn4rq60vn UNIQUE (name);
 M   ALTER TABLE ONLY public.artist DROP CONSTRAINT uk_r03a96lqhsb7djq2tn4rq60vn;
       public            cytech    false    218            �           2606    16458 !   likes fk3ducolygbx3s2eejaic8uw2cc    FK CONSTRAINT        ALTER TABLE ONLY public.likes
    ADD CONSTRAINT fk3ducolygbx3s2eejaic8uw2cc FOREIGN KEY (song_id) REFERENCES public.song(id);
 K   ALTER TABLE ONLY public.likes DROP CONSTRAINT fk3ducolygbx3s2eejaic8uw2cc;
       public          cytech    false    3255    226    219            �           2606    16473 )   playlist_song fk8l4jevlmxwsdm3ppymxm56gh2    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist_song
    ADD CONSTRAINT fk8l4jevlmxwsdm3ppymxm56gh2 FOREIGN KEY (song_id) REFERENCES public.song(id);
 S   ALTER TABLE ONLY public.playlist_song DROP CONSTRAINT fk8l4jevlmxwsdm3ppymxm56gh2;
       public          cytech    false    226    3255    224            �           2606    16483    song fka21ft97nj7thwrp5d31xdaxr    FK CONSTRAINT     �   ALTER TABLE ONLY public.song
    ADD CONSTRAINT fka21ft97nj7thwrp5d31xdaxr FOREIGN KEY (artist_id) REFERENCES public.artist(id);
 I   ALTER TABLE ONLY public.song DROP CONSTRAINT fka21ft97nj7thwrp5d31xdaxr;
       public          cytech    false    218    226    3241            �           2606    16463 $   playlist fkaaj8lctwpjjcrw1l2g75veubp    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT fkaaj8lctwpjjcrw1l2g75veubp FOREIGN KEY (user_id) REFERENCES public.local_user(id);
 N   ALTER TABLE ONLY public.playlist DROP CONSTRAINT fkaaj8lctwpjjcrw1l2g75veubp;
       public          cytech    false    221    3247    223            �           2606    16468 )   playlist_song fkji5gt6i2hcwyt9x1fcfndclva    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist_song
    ADD CONSTRAINT fkji5gt6i2hcwyt9x1fcfndclva FOREIGN KEY (playlist_id) REFERENCES public.playlist(id);
 S   ALTER TABLE ONLY public.playlist_song DROP CONSTRAINT fkji5gt6i2hcwyt9x1fcfndclva;
       public          cytech    false    223    3251    224            �           2606    16448 !   album fkmwc4fyyxb6tfi0qba26gcf8s1    FK CONSTRAINT     �   ALTER TABLE ONLY public.album
    ADD CONSTRAINT fkmwc4fyyxb6tfi0qba26gcf8s1 FOREIGN KEY (artist_id) REFERENCES public.artist(id);
 K   ALTER TABLE ONLY public.album DROP CONSTRAINT fkmwc4fyyxb6tfi0qba26gcf8s1;
       public          cytech    false    216    218    3241            �           2606    16453 !   likes fkpf4v6cpsy8pkjm7ixp30eik61    FK CONSTRAINT     �   ALTER TABLE ONLY public.likes
    ADD CONSTRAINT fkpf4v6cpsy8pkjm7ixp30eik61 FOREIGN KEY (local_user_id) REFERENCES public.local_user(id);
 K   ALTER TABLE ONLY public.likes DROP CONSTRAINT fkpf4v6cpsy8pkjm7ixp30eik61;
       public          cytech    false    3247    221    219            �           2606    16478     song fkrcjmk41yqj3pl3iyii40niab0    FK CONSTRAINT     �   ALTER TABLE ONLY public.song
    ADD CONSTRAINT fkrcjmk41yqj3pl3iyii40niab0 FOREIGN KEY (album_id) REFERENCES public.album(id);
 J   ALTER TABLE ONLY public.song DROP CONSTRAINT fkrcjmk41yqj3pl3iyii40niab0;
       public          cytech    false    216    226    3239            R   <  x����n�0��y
�u����+&XA�"���2��W���P��9�bs OT"�"�Ϲ�>��?������XS��4�b�ۃ��|A���B`�B�9��O�?�ŝ��e���	�&,����ѿ�S��4��V�N���2˗�6C�A8�F��c�2Ff`�Vq~\;�hb��x�DbLi)t��4�yn�����l!'�u%�'	0Bt��$^2qޏ٭�:>l�4!-��V��Vt�����&2���Ӌ�܁(=e�i9��a�&�4$��M���R�i����P]�q>����V�~���ph���C�!��R=���?��LonT X98a�yZ��USl�������`��3G�Va-��k���br���YѶe,mW*��6�3u����¾!sd��F��Q?�K|����K���@X��E��2Zm�	إ����\�@P�H3m�ܻyݟ�>���.D�s��Z�o�Z�	����FItlE�Lܠ�i���$�O�mL!����O�BW���#��"W�,<2������.C��A�3��b����?|<f      T     x���AO�0�;��741��Bi<!l�6���.:��،~z��7{j��y��5�ؔ�m��M����E�z&�A�ڥ��y�n���Ni->}���0Ą`J�v
���S��>xſ`H.��A��w%m3��Uw�@�bE���B��B���f!
@���-�$I�噻A�Z��F�G?ȣ�ѐ����'sW�q�N��W�m�$$��)�w����1�8�Ptg�q�庲8p0�>-��[
�$�}#⢇߅�/	��      U   T   x���v
Q���W((M��L����N-Vs�	uV�0�Q !Mk.OBJ��J��QjVjL�R��Qk
VkA�R�kM�j�� �hG�      W   �   x���
�0 �O��`AL���ѩH�P5�S����*�����gE��$����UCqhj��o�"�:9����X&�MpL�SB�l�I��N�ҫ�P�s�^?�~B�/]*?��l� w����1�Cp�F(i�ۿmTᠭ��0�/�Y*K      Y   X   x���v
Q���W((M��L�+�I���,.Qs�	uV�0�QP74��422617402w	v�774���
pWJ�� ���\\\ �c�      Z   R   x���v
Q���W((M��L�+�I���,.�/��KWs�	uV�0�Q "Mk.Ob���������Ѐ=&`=�@-\\ ۊ=�      \   L  x����R�8 �;_�LU&eI�-ל	�0̒��=M	[I��Vֱ��k��w�cۊ���!���P��D�ؒڗ�ƣ�	��6�A��>Va��9���Fct�z��Q��1��^B(��?Gw�����8�t�H%*Cg�2YM��g4��^E�tڟ�"4Ų����!�C��/G�����(�9�	�zTy�R��A�P#顡HV@S[�����B�Y|�ܽ�	2o��8�\?�E.D��2�o��Ǯ�\�h���e�Ar�DJ�����b��PԁU����^��8�/Z�b.k���5_�OѤB�p�A�H��L���X�1u�b�'\�q$Ut��T���ǆ&��y���~��(R�3������Y%,����"��]����1LB'y�^^v1}��4�����B�CX�-�w��6�%���\�p�Uf����m��zeiAG�ۦy�gx
�g!ejVj]x�F2C�3�Z�fUl��n������|
(=�d.���T�O�E�B��"�u��p��&g����k	 �}� S��¯:��~�l�&0����i�,�}��`RYzh,2����^�� �P�D��J����L���]��Ro�H�:u��1��Lűx�f��O��M���8�,Vi�F�F~hٛnw���,.��C������a��5�s]�#�(!5Ĺ�1���]�a��Ta�a5���<��L� �;���.TmF�|�a�ד��vwaR.�M
 �h��͠��i�ebҞ؇�=1���N<Q�D�6[a.�hs4����ơmN@]N͜W�A�9Ƭ�J�y,a��`�ٰ���v��"c普�28`���n�����s~EoAs�u��N��"�Z�A
[v��_�K�׭��yi�{w'	:*hTf1�~��"i��&M(��B
�I-�,��]3��Cwc��u��4>s8����#J�J>J�R�W�����&�n��vC�ִ�s2��}�s2�!�{�:[��e.�:���v ���,ٲ�5�W�Yy�f���>����{h�8����2�y�8[��f�ќ���W�7�B��Fvw<���';� ΰ}<���D�,z{ݜ���e��EGG�Y���     