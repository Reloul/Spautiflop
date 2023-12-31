--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0 (Debian 16.0-1.pgdg120+1)
-- Dumped by pg_dump version 16.0

-- Started on 2023-11-05 22:56:44 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE spautiflop;
--
-- TOC entry 3428 (class 1262 OID 16384)
-- Name: spautiflop; Type: DATABASE; Schema: -; Owner: cytech
--

CREATE DATABASE spautiflop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE spautiflop OWNER TO cytech;

\connect spautiflop

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16389)
-- Name: album; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.album (
    id bigint NOT NULL,
    image character varying(255),
    name character varying(255) NOT NULL,
    release character varying(255),
    artist_id bigint NOT NULL
);


ALTER TABLE public.album OWNER TO cytech;

--
-- TOC entry 216 (class 1259 OID 16394)
-- Name: album_id_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.album_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.album_id_seq OWNER TO cytech;

--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 216
-- Name: album_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cytech
--

ALTER SEQUENCE public.album_id_seq OWNED BY public.album.id;


--
-- TOC entry 217 (class 1259 OID 16395)
-- Name: artist; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.artist (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    photo character varying(255)
);


ALTER TABLE public.artist OWNER TO cytech;

--
-- TOC entry 218 (class 1259 OID 16400)
-- Name: artist_id_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.artist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.artist_id_seq OWNER TO cytech;

--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 218
-- Name: artist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cytech
--

ALTER SEQUENCE public.artist_id_seq OWNED BY public.artist.id;


--
-- TOC entry 219 (class 1259 OID 16401)
-- Name: likes; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.likes (
    id bigint NOT NULL,
    local_user_id bigint,
    song_id bigint
);


ALTER TABLE public.likes OWNER TO cytech;

--
-- TOC entry 220 (class 1259 OID 16404)
-- Name: likes_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.likes_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.likes_seq OWNER TO cytech;

--
-- TOC entry 221 (class 1259 OID 16405)
-- Name: local_user; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.local_user (
    id bigint NOT NULL,
    password character varying(1000) NOT NULL,
    photo character varying(255) NOT NULL,
    pseudo character varying(255) NOT NULL
);


ALTER TABLE public.local_user OWNER TO cytech;

--
-- TOC entry 222 (class 1259 OID 16410)
-- Name: local_user_id_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.local_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.local_user_id_seq OWNER TO cytech;

--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 222
-- Name: local_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cytech
--

ALTER SEQUENCE public.local_user_id_seq OWNED BY public.local_user.id;


--
-- TOC entry 223 (class 1259 OID 16411)
-- Name: playlist; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.playlist (
    id bigint NOT NULL,
    image character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE public.playlist OWNER TO cytech;

--
-- TOC entry 224 (class 1259 OID 16416)
-- Name: playlist_id_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.playlist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.playlist_id_seq OWNER TO cytech;

--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 224
-- Name: playlist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cytech
--

ALTER SEQUENCE public.playlist_id_seq OWNED BY public.playlist.id;


--
-- TOC entry 225 (class 1259 OID 16417)
-- Name: playlist_song; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.playlist_song (
    id bigint NOT NULL,
    playlist_id bigint,
    song_id bigint
);


ALTER TABLE public.playlist_song OWNER TO cytech;

--
-- TOC entry 226 (class 1259 OID 16420)
-- Name: playlist_song_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.playlist_song_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.playlist_song_seq OWNER TO cytech;

--
-- TOC entry 227 (class 1259 OID 16421)
-- Name: song; Type: TABLE; Schema: public; Owner: cytech
--

CREATE TABLE public.song (
    id bigint NOT NULL,
    genre character varying(255),
    image character varying(255),
    music_link character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    nb_likes bigint NOT NULL,
    album_id bigint,
    artist_id bigint
);


ALTER TABLE public.song OWNER TO cytech;

--
-- TOC entry 228 (class 1259 OID 16426)
-- Name: song_id_seq; Type: SEQUENCE; Schema: public; Owner: cytech
--

CREATE SEQUENCE public.song_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.song_id_seq OWNER TO cytech;

--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 228
-- Name: song_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cytech
--

ALTER SEQUENCE public.song_id_seq OWNED BY public.song.id;


--
-- TOC entry 3233 (class 2604 OID 16427)
-- Name: album id; Type: DEFAULT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.album ALTER COLUMN id SET DEFAULT nextval('public.album_id_seq'::regclass);


--
-- TOC entry 3234 (class 2604 OID 16428)
-- Name: artist id; Type: DEFAULT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.artist ALTER COLUMN id SET DEFAULT nextval('public.artist_id_seq'::regclass);


--
-- TOC entry 3235 (class 2604 OID 16429)
-- Name: local_user id; Type: DEFAULT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.local_user ALTER COLUMN id SET DEFAULT nextval('public.local_user_id_seq'::regclass);


--
-- TOC entry 3236 (class 2604 OID 16430)
-- Name: playlist id; Type: DEFAULT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.playlist ALTER COLUMN id SET DEFAULT nextval('public.playlist_id_seq'::regclass);


--
-- TOC entry 3237 (class 2604 OID 16431)
-- Name: song id; Type: DEFAULT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.song ALTER COLUMN id SET DEFAULT nextval('public.song_id_seq'::regclass);


--
-- TOC entry 3409 (class 0 OID 16389)
-- Dependencies: 215
-- Data for Name: album; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.album VALUES (1, '1699221502829XEU.jpg', 'XEU', '08-05-1973', 7);
INSERT INTO public.album VALUES (2, '1699221526431vald_vitrine.jpg', 'Agartha', '08-05-1973', 7);
INSERT INTO public.album VALUES (3, '1699221578935MGMTOS.jpg', 'Oracular Spectacular', '08-09-2007', 8);
INSERT INTO public.album VALUES (4, '1699221602266MGMTLDA.jpg', 'Little Dark Age', '18-09-2008', 8);
INSERT INTO public.album VALUES (5, '1699221632116french79.jpg', 'Olympic', '04-06-2009', 6);
INSERT INTO public.album VALUES (6, '1699221712984HWTH_acdc.jpg', 'Highway To Hell', '18-11-2009', 4);
INSERT INTO public.album VALUES (7, '1699221756654bowieHeroes.png', 'Heroes', '18-11-2009', 2);
INSERT INTO public.album VALUES (8, '1699221770392davidBowie.png', 'David Bowie', '18-11-2009', 2);
INSERT INTO public.album VALUES (9, '1699221795546TheRizzBowie.png', 'The rise', '18-11-2009', 2);
INSERT INTO public.album VALUES (10, '1699221847366toutekalle.png', 'Touté Kalé', '16-06-2011', 5);
INSERT INTO public.album VALUES (11, '1699221882167afrique.png', 'Africainement votre', '16-06-2011', 5);
INSERT INTO public.album VALUES (12, '1699221929028fl3r_Flame.jpg', 'Flame', '16-08-2017', 3);
INSERT INTO public.album VALUES (13, '1699221960400fl3r.jpg', 'We believe in you ', '16-08-2017', 3);
INSERT INTO public.album VALUES (14, '1699221983962gorillaz.png', 'Gorillaz', '16-08-2017', 1);
INSERT INTO public.album VALUES (15, '1699221995897gorillazDem.png', 'Demon days', '16-08-2017', 1);
INSERT INTO public.album VALUES (16, '1699222040438V4.jpg', 'Moonless', '16-08-2017', 3);
INSERT INTO public.album VALUES (17, '1699222694452davidBowie.png', 'David Bowie', '', 9);
INSERT INTO public.album VALUES (18, '1699222711962TheRizzBowie.png', 'The rise', '', 9);
INSERT INTO public.album VALUES (19, '1699222742073TheRizzBowie.png', 'Heroes', '', 9);
INSERT INTO public.album VALUES (20, '1699222781417TheRizzBowie.png', 'Olympic', '', 9);


--
-- TOC entry 3411 (class 0 OID 16395)
-- Dependencies: 217
-- Data for Name: artist; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.artist VALUES (1, 'Gorillaz', '1699221331445gorillazpp.png');
INSERT INTO public.artist VALUES (2, 'David Bowie', '1699221354710Bowie.png');
INSERT INTO public.artist VALUES (3, 'FL3R', '1699221372111Fl3rpp.jpg');
INSERT INTO public.artist VALUES (4, 'AC/DC', '1699221396388ACDC.jpg');
INSERT INTO public.artist VALUES (5, 'Magic System', '1699221423709magicSystem.jpg');
INSERT INTO public.artist VALUES (6, 'French79', '1699221438364french79_a.jpg');
INSERT INTO public.artist VALUES (7, 'Vald', '1699221447970vald.jpg');
INSERT INTO public.artist VALUES (8, 'MGMT', '1699221469910MGMT.jpg');
INSERT INTO public.artist VALUES (9, 'Davie Bowie', 'images_default.png');


--
-- TOC entry 3413 (class 0 OID 16401)
-- Dependencies: 219
-- Data for Name: likes; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.likes VALUES (1, 1, 1);
INSERT INTO public.likes VALUES (2, 1, 2);
INSERT INTO public.likes VALUES (3, 1, 3);
INSERT INTO public.likes VALUES (4, 1, 10);
INSERT INTO public.likes VALUES (5, 1, 8);
INSERT INTO public.likes VALUES (52, 1, 4);


--
-- TOC entry 3415 (class 0 OID 16405)
-- Dependencies: 221
-- Data for Name: local_user; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.local_user VALUES (1, '$2a$10$/l4WL.MH1DRzeJEje5T4Ve9ihYM85kpnl/q1kk73.ex3952zV1F9m', '1699220518856luciole.jpg', 'BigFlop');


--
-- TOC entry 3417 (class 0 OID 16411)
-- Dependencies: 223
-- Data for Name: playlist; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.playlist VALUES (1, '1699223471027DSC_7179.JPG', 'Sport', 1);


--
-- TOC entry 3419 (class 0 OID 16417)
-- Dependencies: 225
-- Data for Name: playlist_song; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.playlist_song VALUES (1, 1, 4);
INSERT INTO public.playlist_song VALUES (2, 1, 5);
INSERT INTO public.playlist_song VALUES (3, 1, 10);
INSERT INTO public.playlist_song VALUES (4, 1, 9);


--
-- TOC entry 3421 (class 0 OID 16421)
-- Dependencies: 227
-- Data for Name: song; Type: TABLE DATA; Schema: public; Owner: cytech
--

INSERT INTO public.song VALUES (5, 'vald', '1699222353613XEU.jpg', '1699222353583Vladimir Cauchemar, Vald - Elévation.flac', 'Elevation', 0, 1, 7);
INSERT INTO public.song VALUES (6, 'vald', '1699222518892vald_vitrine.jpg', '1699222518693Vald, Damso - Vitrine.flac', 'Vitrine', 0, 2, 7);
INSERT INTO public.song VALUES (7, 'boom boom', '1699222583647toutekalle.png', '1699222583565Magic System - Ambiance à l''africaine.flac', 'Ambiance a l''africaine', 0, 10, 5);
INSERT INTO public.song VALUES (9, 'plage', '1699222624364afrique.png', '1699222624287Magic System - Tu es fou.flac', 'Tu es fou', 0, 11, 5);
INSERT INTO public.song VALUES (11, 'val', '1699222694511davidBowie.png', '1699222694465David Bowie - Space Oddity - 2015 Remaster.flac', 'Space oddity', 0, 17, 9);
INSERT INTO public.song VALUES (12, 'val', '1699222712013TheRizzBowie.png', '1699222711972David Bowie - Starman - 2012 Remaster.flac', 'Starman', 0, 18, 9);
INSERT INTO public.song VALUES (13, 'val', '1699222742149TheRizzBowie.png', '1699222742087David Bowie - Heroes - 2017 Remaster.flac', 'Hereos', 0, 19, 9);
INSERT INTO public.song VALUES (14, 'val', '1699222762751TheRizzBowie.png', '1699222762703Queen, David Bowie - Under Pressure.flac', 'Under Pressure', 0, 19, 9);
INSERT INTO public.song VALUES (15, 'fr', '1699222781488TheRizzBowie.png', '1699222781433French 79 - Between the Buttons.flac', 'Between The Buttons', 0, 20, 9);
INSERT INTO public.song VALUES (16, 'fr', '1699222791435TheRizzBowie.png', '1699222791388French 79 - Hometown.flac', 'HomeTown', 0, 20, 9);
INSERT INTO public.song VALUES (17, 'fr', '1699222806943TheRizzBowie.png', '1699222806912French 79, Sarah Rebecca - Diamond Veins (feat. Sarah Rebecca).flac', 'Diamond Veins', 0, 20, 9);
INSERT INTO public.song VALUES (18, 'fr', '1699223030815gorillaz.png', '1699223030721Gorillaz - 19-2000.flac', 'Clint EastWood', 0, 14, 1);
INSERT INTO public.song VALUES (19, 'fr', '1699223041155gorillaz.png', '1699223041073Gorillaz - 19-2000.flac', '19-2000', 0, 14, 1);
INSERT INTO public.song VALUES (20, 'fr', '1699223056440gorillaz.png', '1699223056322Gorillaz - Feel Good Inc..flac', 'Feel Good', 0, 15, 1);
INSERT INTO public.song VALUES (21, 'fr', '1699223066654gorillazDem.png', '1699223066602Gorillaz - Feel Good Inc..flac', 'Feel Good', 0, 15, 1);
INSERT INTO public.song VALUES (51, 'oui', '1699223357605MGMTOS.jpg', '1699223357437MGMT - Kids.flac', 'Kids', 0, 3, 8);
INSERT INTO public.song VALUES (52, 'oui', '1699223372338MGMTOS.jpg', '1699223372309MGMT - Time to Pretend.flac', 'Time to pretend', 0, 3, 8);
INSERT INTO public.song VALUES (53, 'oui', '1699223393483MGMTLDA.jpg', '1699223393455MGMT - Little Dark Age.flac', 'Little Dark Age', 0, 4, 8);
INSERT INTO public.song VALUES (1, 'electro', '1699222195177V4.jpg', '1699222193680FL3R - Moonless (Paularis Anthem).flac', 'Moonless', 1, 16, 3);
INSERT INTO public.song VALUES (2, 'electro', '1699222243944fl3r_Flame.jpg', '1699222243923Stanhead, FL3R - Flame.flac', 'Flame', 1, 12, 3);
INSERT INTO public.song VALUES (3, 'electro', '1699222275108fl3r.jpg', '1699222275085FL3R - We Believe in You.flac', 'We believe in you', 1, 13, 3);
INSERT INTO public.song VALUES (10, 'plage', '1699222652694afrique.png', '1699222652583Magic System, Chawki - Magic in the Air (feat. Ahmed Chawki).flac', 'Magic in the air', 1, 10, 5);
INSERT INTO public.song VALUES (8, 'boom boom', '1699222597357toutekalle.png', '1699222597288Magic System, Soprano - Chérie Coco - feat. Soprano.flac', 'Cherie Coco', 1, 10, 5);
INSERT INTO public.song VALUES (4, 'vald', '1699222335882XEU.jpg', '1699222335851Vald - Désaccordé.flac', 'Désaccordé', 1, 1, 7);


--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 216
-- Name: album_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.album_id_seq', 20, true);


--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 218
-- Name: artist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.artist_id_seq', 9, true);


--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 220
-- Name: likes_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.likes_seq', 101, true);


--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 222
-- Name: local_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.local_user_id_seq', 1, true);


--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 224
-- Name: playlist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.playlist_id_seq', 1, true);


--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 226
-- Name: playlist_song_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.playlist_song_seq', 51, true);


--
-- TOC entry 3440 (class 0 OID 0)
-- Dependencies: 228
-- Name: song_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cytech
--

SELECT pg_catalog.setval('public.song_id_seq', 53, true);


--
-- TOC entry 3239 (class 2606 OID 16433)
-- Name: album album_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id);


--
-- TOC entry 3241 (class 2606 OID 16435)
-- Name: artist artist_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.artist
    ADD CONSTRAINT artist_pkey PRIMARY KEY (id);


--
-- TOC entry 3245 (class 2606 OID 16437)
-- Name: likes likes_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT likes_pkey PRIMARY KEY (id);


--
-- TOC entry 3247 (class 2606 OID 16439)
-- Name: local_user local_user_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.local_user
    ADD CONSTRAINT local_user_pkey PRIMARY KEY (id);


--
-- TOC entry 3251 (class 2606 OID 16441)
-- Name: playlist playlist_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (id);


--
-- TOC entry 3253 (class 2606 OID 16443)
-- Name: playlist_song playlist_song_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.playlist_song
    ADD CONSTRAINT playlist_song_pkey PRIMARY KEY (id);


--
-- TOC entry 3255 (class 2606 OID 16445)
-- Name: song song_pkey; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.song
    ADD CONSTRAINT song_pkey PRIMARY KEY (id);


--
-- TOC entry 3249 (class 2606 OID 16447)
-- Name: local_user uk_29clp9ilw1eslbtgdnm9d5vwa; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.local_user
    ADD CONSTRAINT uk_29clp9ilw1eslbtgdnm9d5vwa UNIQUE (pseudo);


--
-- TOC entry 3257 (class 2606 OID 16449)
-- Name: song uk_4b9skxyi4nggvr7ekjo5fev4o; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.song
    ADD CONSTRAINT uk_4b9skxyi4nggvr7ekjo5fev4o UNIQUE (music_link);


--
-- TOC entry 3243 (class 2606 OID 16451)
-- Name: artist uk_r03a96lqhsb7djq2tn4rq60vn; Type: CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.artist
    ADD CONSTRAINT uk_r03a96lqhsb7djq2tn4rq60vn UNIQUE (name);


--
-- TOC entry 3259 (class 2606 OID 16452)
-- Name: likes fk3ducolygbx3s2eejaic8uw2cc; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT fk3ducolygbx3s2eejaic8uw2cc FOREIGN KEY (song_id) REFERENCES public.song(id);


--
-- TOC entry 3262 (class 2606 OID 16457)
-- Name: playlist_song fk8l4jevlmxwsdm3ppymxm56gh2; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.playlist_song
    ADD CONSTRAINT fk8l4jevlmxwsdm3ppymxm56gh2 FOREIGN KEY (song_id) REFERENCES public.song(id);


--
-- TOC entry 3264 (class 2606 OID 16462)
-- Name: song fka21ft97nj7thwrp5d31xdaxr; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.song
    ADD CONSTRAINT fka21ft97nj7thwrp5d31xdaxr FOREIGN KEY (artist_id) REFERENCES public.artist(id);


--
-- TOC entry 3261 (class 2606 OID 16467)
-- Name: playlist fkaaj8lctwpjjcrw1l2g75veubp; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT fkaaj8lctwpjjcrw1l2g75veubp FOREIGN KEY (user_id) REFERENCES public.local_user(id);


--
-- TOC entry 3263 (class 2606 OID 16472)
-- Name: playlist_song fkji5gt6i2hcwyt9x1fcfndclva; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.playlist_song
    ADD CONSTRAINT fkji5gt6i2hcwyt9x1fcfndclva FOREIGN KEY (playlist_id) REFERENCES public.playlist(id);


--
-- TOC entry 3258 (class 2606 OID 16477)
-- Name: album fkmwc4fyyxb6tfi0qba26gcf8s1; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT fkmwc4fyyxb6tfi0qba26gcf8s1 FOREIGN KEY (artist_id) REFERENCES public.artist(id);


--
-- TOC entry 3260 (class 2606 OID 16482)
-- Name: likes fkpf4v6cpsy8pkjm7ixp30eik61; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT fkpf4v6cpsy8pkjm7ixp30eik61 FOREIGN KEY (local_user_id) REFERENCES public.local_user(id);


--
-- TOC entry 3265 (class 2606 OID 16487)
-- Name: song fkrcjmk41yqj3pl3iyii40niab0; Type: FK CONSTRAINT; Schema: public; Owner: cytech
--

ALTER TABLE ONLY public.song
    ADD CONSTRAINT fkrcjmk41yqj3pl3iyii40niab0 FOREIGN KEY (album_id) REFERENCES public.album(id);


-- Completed on 2023-11-05 22:56:44 UTC

--
-- PostgreSQL database dump complete
--

