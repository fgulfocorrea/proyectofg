import Api from '@/services/Api'
/* eslint-disable */
export default {
    listadoRoles() {
        return Api().get('role/listar/')
    },
    guardar(params) {
        console.log(params)
        return Api().post('role/guardar/',params)
    },
}