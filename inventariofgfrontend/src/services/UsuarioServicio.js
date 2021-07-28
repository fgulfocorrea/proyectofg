import Api from '@/services/Api'
/* eslint-disable */
export default {
    obtenerUsuarios(params) {
        return Api().get('usuario/listar/')
    },
}