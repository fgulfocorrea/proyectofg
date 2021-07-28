import Vue from 'vue/dist/vue.js';
import Router from 'vue-router'
import Principal from '@/components/Principal'
import Mercancia from '@/components/Mercancia'
import Usuario from '@/components/Usuario'
import Role from '@/components/Role'
// import NuestraEmpresa from '@/components/NuestraEmpresa'
// import Proyectos from '@/components/Proyectos'
// import ProyectosEnDesarrollo from '@/components/ProyectosEnDesarrollo'
// import Contacto from '@/components/Contacto'
// import Administracion from '@/components/Administracion'
// import CrudAdministracion from '@/components/CrudAdministracion'
// import VuePaginate from 'vue-paginate'
import VueToast from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-sugar.css';
import VueResource from 'vue-resource';
import vSelect from "vue-select";
/* eslint-disable */
Vue.use(Router)
// Vue.use(VuePaginate)
Vue.use(VueResource);
Vue.use(VueToast)
Vue.component("v-select", vSelect);

const router = new Router({  
  routes: [ 
    {
        path: '*',
        redirect: '/principal'
    },
    {
        path: '/',
        redirect: '/principal'
    },
    {
        path: '/principal', 
        name: 'Principal',
        component: Principal
    },
    {
        path: '/mercancia',
        name: 'Mercancia',
        component: Mercancia,
        props: true
    },
    {
      path: '/usuario',
      name: 'Usuario',
      component: Usuario,
      props: true
    },
    {
      path: '/role',
      name: 'Role',
      component: Role,
      props: true
    },
    // {      
    //     path: '/proyectos',
    //     name: 'Proyectos',
    //     component: Proyectos
    // },
    // {      
    //     path: '/proyectosEnDesarrollo',
    //     name: 'ProyectosEnDesarrollo',
    //     component: ProyectosEnDesarrollo
    // },
    // {
    //     path: '/contacto',
    //     name: 'Contacto',
    //     component: Contacto
    // },
    // {      
    //     path: '/administracion',
    //     name: 'Administracion',
    //     component: Administracion
    // },
    // {      
    //     path: '/crudAdministracion',
    //     name: 'CrudAdministracion',
    //     component: CrudAdministracion
    // },
  ]
})

router.beforeEach((to, from, next) => {
  console.log(to.path);
  next();
/*
  if (to.path == '/principal' && !autorizacion && !usuario) {
    next('home');
  } else if (to.path == '/administracion' && autorizacion && usuario){
    console.log('inAdm');
    next();
  }else if (to.path == '/login' && !autorizacion && !usuario){
    console.log('inLog');
    next();
  } else{
    next();
  }*/
})

export default router;