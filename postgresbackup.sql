--
-- PostgreSQL database dump
--

-- Dumped from database version 10.17 (Ubuntu 10.17-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.17 (Ubuntu 10.17-0ubuntu0.18.04.1)

-- Started on 2021-07-27 23:16:23 -05

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

--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 2977
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 1 (class 3079 OID 13081)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 196 (class 1259 OID 27250)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: prueba
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO prueba;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 27252)
-- Name: mercancias; Type: TABLE; Schema: public; Owner: prueba
--

CREATE TABLE public.mercancias (
    id bigint NOT NULL,
    cantidad integer NOT NULL,
    estado boolean NOT NULL,
    fecha_ingreso date NOT NULL,
    fecha_modificacion date,
    nombre_producto character varying(200) NOT NULL,
    usuario_creacion_id bigint,
    usuario_modificacion_id bigint
);


ALTER TABLE public.mercancias OWNER TO prueba;

--
-- TOC entry 198 (class 1259 OID 27257)
-- Name: personas; Type: TABLE; Schema: public; Owner: prueba
--

CREATE TABLE public.personas (
    id bigint NOT NULL,
    apellidos character varying(200) NOT NULL,
    edad integer NOT NULL,
    email character varying(100) NOT NULL,
    estado boolean NOT NULL,
    identificacion character varying(15) NOT NULL,
    nombres character varying(200) NOT NULL,
    telefono character varying(10) NOT NULL
);


ALTER TABLE public.personas OWNER TO prueba;

--
-- TOC entry 199 (class 1259 OID 27265)
-- Name: roles; Type: TABLE; Schema: public; Owner: prueba
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    descripcion character varying(200) NOT NULL,
    estado boolean NOT NULL,
    nombre character varying(100) NOT NULL
);


ALTER TABLE public.roles OWNER TO prueba;

--
-- TOC entry 200 (class 1259 OID 27270)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: prueba
--

CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    estado boolean NOT NULL,
    fecha_ingreso date NOT NULL,
    nombre character varying(100) NOT NULL,
    persona_id bigint,
    role_id bigint
);


ALTER TABLE public.usuarios OWNER TO prueba;

--
-- TOC entry 2840 (class 2606 OID 27256)
-- Name: mercancias mercancias_pkey; Type: CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.mercancias
    ADD CONSTRAINT mercancias_pkey PRIMARY KEY (id);


--
-- TOC entry 2842 (class 2606 OID 27264)
-- Name: personas personas_pkey; Type: CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (id);


--
-- TOC entry 2844 (class 2606 OID 27269)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2846 (class 2606 OID 27274)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 2847 (class 2606 OID 27275)
-- Name: mercancias fk2p1axofmhqybfgu76078co89k; Type: FK CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.mercancias
    ADD CONSTRAINT fk2p1axofmhqybfgu76078co89k FOREIGN KEY (usuario_creacion_id) REFERENCES public.usuarios(id);


--
-- TOC entry 2850 (class 2606 OID 27290)
-- Name: usuarios fkeljjw3mx8n5ngoe7fbqbjwusp; Type: FK CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fkeljjw3mx8n5ngoe7fbqbjwusp FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 2848 (class 2606 OID 27280)
-- Name: mercancias fkjbc57fagudy1xr4m14hc4d4qw; Type: FK CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.mercancias
    ADD CONSTRAINT fkjbc57fagudy1xr4m14hc4d4qw FOREIGN KEY (usuario_modificacion_id) REFERENCES public.usuarios(id);


--
-- TOC entry 2849 (class 2606 OID 27285)
-- Name: usuarios fkoesedii3ntyaw1650vh2d9jso; Type: FK CONSTRAINT; Schema: public; Owner: prueba
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fkoesedii3ntyaw1650vh2d9jso FOREIGN KEY (persona_id) REFERENCES public.personas(id);


-- Completed on 2021-07-27 23:16:23 -05

--
-- PostgreSQL database dump complete
--

