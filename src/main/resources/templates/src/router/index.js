import { createRouter,createWebHistory } from "vue-router";
import PageAccueil from "../view/PageAccueil";

const routes = [
    {
        path:'/',
        name: 'Accueil',
        component: PageAccueil
    },
    {
        path:'/connexion',
        name: 'Connexion',
        component: () => import(/* webpackChunkName: "connexion" */ '../view/PageConnexion.vue' ),
        meta: {
            hideSongProgress: true
        }
    },
    {
        path:'/inscription',
        name: 'Inscription',
        component: () => import(/* webpackChunkName: "inscription" */ '../view/PageInscription.vue' ),
        meta: {
            hideSongProgress: true
        }
    },
    {
        path:'/pagePrincipale',
        name:'pagePrincipale',
        component: () => import(/* webpackChunkName: "pagePrincipale" */ '../view/PagePrincipale.vue'),
    },
    {
        path:'/playlist/:id',
        name:'Playlist',
        component: () => import(/* webpackChunkName: "playlist" */ '../view/MaPlaylist.vue'),
    },
    {
        path:'/recherche',
        name:'Search',
        component: () => import(/* webpackChunkName: "recherche" */ '../view/SearchPage.vue'),
    },
    {
        path:'/album',
        name:'Album',
        component: () => import(/* webpackChunkName: "album" */ '../view/AlbumPage.vue'),
    },
    {
        path:'/artist',
        name: "Artist",
        component: () => import(/* webpackChunkName: "artist" */ '../view/ArtistPage.vue'),
    },
    {
        path:'/test',
        name:'Test',
        component: () => import(/* webpackChunkName: "test" */ '../components/TestPage.vue'),
    },
    {
        path:'/ajoutMusique',
        name:"AjoutMusique",
        component: () => import(/* webpackChunkName: "ajoutMusique" */ '../view/AddMusic.vue'),
        meta: {
            hideSongProgress: true
        }
    },/*
    {
        path:'/ajoutAll',
        name:'AjoutAll',
        component: () => import(/* webpackChunkName: "ajoutAll"  '../view/AddAll.vue'),
        /*meta: {
            hideSongProgress: true
        }
    },*/
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
})


export default router