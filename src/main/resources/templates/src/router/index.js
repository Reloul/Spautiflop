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
        component: () => import(/* webpackChunkName: "connexion" */ '../view/PageConnexion.vue' )
    },
    {
        path:'/inscription',
        name: 'Inscription',
        component: () => import(/* webpackChunkName: "inscription" */ '../view/PageInscription.vue' )
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router