import Api from '@/services/Api'
/* eslint-disable */
export default {
    listadoMercancias() {
        return Api().get('mercancia/listar/')
    },
    guardar(params) {
        console.log(params)
        return Api().post('mercancia/guardar/',params)
    },
    modificar(params) {
        console.log(params)
        return Api().post('mercancia/modificar/',params)
    },
    buscar(params) {
        console.log(params)
        return Api().post('mercancia/filtrar/'+params.nombre)
    },
    eliminar(params) {
        console.log(params)
        return Api().post('mercancia/eliminar/'+params.id)
    },
}