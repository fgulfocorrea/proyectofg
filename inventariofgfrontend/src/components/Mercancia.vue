<template>
    <div class="Mercancia">
        <div class="card-body card-body-mercancia text-center">
          <h4 class="titulo1">{{titulo}}</h4>
            <form>
              <div class="row">
                <div class="col-sm-12 text-left">
                  <label for="inputFechaIngreso" class="sr-only">Fecha Ingreso </label>
                  <input
                    v-model="newMercancia.fechaIngreso"
                    type="text"
                    id="inputFechaIngreso"
                    class="form-control"
                    placeholder="dd-mm-yyyy"
                    required
                    autofocus
                    ref="cantidad"
                  />
                  <label for="inputNombreProducto" class="sr-only">Nombre Producto </label>
                  <input
                    v-model="newMercancia.nombreProducto"
                    type="text"
                    id="inputNombreProducto"
                    class="form-control"
                    placeholder="Nombre Producto"
                    required
                    autofocus
                    ref="nombre"
                  />
                </div>
              </div>
              <div class="row">
                
              </div>
              <div v-if="this.guardar" class="row">
                <div class="col-sm-12 text-left">
                    <label for="usuarioCreacion">Usuario Creacion </label>
                    <select v-model="usuarioSeleccionado" class="form-control" id="usuarioCreacion">
                        <option v-for="usuario in usuarios" :key="usuario.id" :value="usuario">{{usuario.nombre}}</option>
                    </select>
                    <label for="inputCantidad" class="sr-only">Cantidad </label>
                  <input
                    v-model="newMercancia.cantidad"
                    type="text"
                    id="inputCantidad"
                    class="form-control"
                    placeholder="Cantidad"
                    required
                    autofocus
                    ref="cantidad"
                  />
                </div>
              </div>
              <div v-else class="row">
                <div class="col-sm-12 text-left">
                    <label for="usuarioModificacion">Usuario Modificacion </label>
                    <select v-model="usuarioModSeleccionado" class="form-control" id="usuarioModificacion">
                        <option v-for="usuario in usuarios" :key="usuario.id" :value="usuario">{{usuario.nombre}}</option>
                    </select>
                    <label for="inputCantidad" class="sr-only">Cantidad </label>
                  <input
                    v-model="newMercancia.cantidad"
                    type="text"
                    id="inputCantidad"
                    class="form-control"
                    placeholder="Cantidad"
                    required
                    autofocus
                    ref="cantidad"
                  />
                </div>
              </div>
              <div class="row mt-2">
                <div v-if="this.guardar" class="col-sm-12">
                  <button type="submit" @click.prevent="crearMercancia" class="btn btn-outline-info active">Guardar</button>
                </div>
                <div v-else class="col-sm-12">
                  <button type="submit" @click.prevent="actualizarOpcion(newMercancia.id)" class="btn btn-outline-info active">Modificar</button>
                </div>
              </div>
              <div v-if="this.mesage.error" class="row mt-2">
                <h6>{{this.mesage.msg}}</h6>
              </div>
              <div class="row">
                <span>Filtro</span>
              </div>
              <div class="row">
                <input
                    v-model="filtroNombre"
                    type="text"
                    id="inputfiltroNombre"
                    class="form-control"
                    placeholder="Nombre Producto"
                    required
                    autofocus
                    ref="filtroNombre"
                  />
                  <button type="submit" @click.prevent="buscar" class="btn btn-outline-info active">Buscar</button>
              </div>
              <div class="col-sm-12 mitabla">
                <table>
                  <thead>
                      <th>Producto</th>
                      <th>Cantidad</th>
                      <th>Fecha Ingreso</th>
                      <th>Usuario Creacion</th>
                      <th>Usuario Modificacion</th>
                      <th>Acciones</th>
                  </thead>
                  <tbody v-if="mercancias.lenght = 0">
                    <h3 type="info">
                      {{this.msg}}
                    </h3>
                  </tbody>
                  <tbody v-else>
                    <tr v-for="mercancia in mercancias" :key="mercancia.id">
                      <td>
                        {{mercancia.nombreProducto}}
                      </td>
                      <td>
                        {{mercancia.cantidad}}
                      </td>
                      <td>
                        {{mercancia.fechaIngreso}}
                      </td>
                      <td>
                        {{mercancia.usuarioCreacion.nombre}}
                      </td>
                      <td v-if="mercancia.usuarioModificacion != null">
                        {{mercancia.usuarioModificacion.nombre}}
                      </td>
                      <td v-else>
                        
                      </td>
                      <td>
                        <button type="button" @click.prevent="editar(mercancia)" 
                                class="btn btn-sm btn-outline-info" aria-label="Left Align">Editar
                        </button>
                        <button type="button" @click.prevent="eliminar(mercancia)"
                        class="btn btn-sm btn-outline-info" aria-label="Left Align">
                        Eliminar
                        </button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
          </form>
      </div>
    </div>
</template>

<script>
/* eslint-disable */

import mercanciaServicio from '@/services/MercanciaServicio'
import usuarioServicio from '@/services/UsuarioServicio'
import moment from "moment";

export default {
    name: 'Mercancia',
    data (){
      return {
        newMercancia:{
          nombreProducto:"",
          cantidad:0,
          fechaIngreso:moment().format('YYYY-MM-DD'),
          usuarioCreacion:"",
          usuarioModificacion:"",
          fechaModificacion:"",
          estado:1
        },
        idMercancia:"",
        guardar:true,
        msg:"",
        mesage:{
          msg:"",
          error:false,
          suces:false
        },
        mercancias: [],
        usuarios: [],
        usuarioSeleccionado: {},
        usuarioModSeleccionado: {},
        event_at: new Date(),
        titulo: "Listado Mercancias",
        filtroNombre:''
        // denominaciones: [],
        // denominacionSeleccionado: {},
        // denominacionDineroSeleccionado: {},
        // monedaSeleccionado: {},
        // cantidad:"",
        // cantidadMonedas:"",
        // cantidadDenominacion:"",
        // cantidadDineroDenominacion:""
      }
    },
    // beforeUpdate(){
    // },
    methods: {

      async obtenerListadoMercancia() {
        const response = await mercanciaServicio.listadoMercancias();
        console.log(response.data)
        this.mercancias = response.data.listaMercancia
        this.msg = response.data.msg
        
        this.listaUsuarios();
        // this.obtenerCantidadMonedas()
      },

      async crearMercancia(){
        this.newMercancia.usuarioCreacion=this.usuarioSeleccionado

        const response = await mercanciaServicio.guardar({
             "nombreProducto":this.newMercancia.nombreProducto,
          "cantidad":this.newMercancia.cantidad,
          "fechaIngreso":this.newMercancia.fechaIngreso,
          "usuarioCreacion":this.newMercancia.usuarioCreacion,
          "usuarioModificacion":null,
          "fechaModificacion":null,
          "estado":this.newMercancia.estado
        });
        console.log(response.data)
        this.mesage = response.data.msg
        this.limpiarObjeto()
        this.obtenerListadoMercancia();
      },

      async editar(editMercancia){
        this.newMercancia = editMercancia
        this.usuarioSeleccionado = editMercancia.usuarioCreacion
        this.idMercancia = editMercancia.id
        console.log("id:"+this.idMercancia)
        this.guardar = false
      },

      async actualizarOpcion(id) {
        console.log('actualizando')
        this.newMercancia.usuarioCreacion=this.usuarioSeleccionado
        this.newMercancia.usuarioModificacion = this.usuarioModSeleccionado
        
        const response = await mercanciaServicio.modificar({
            "id":id,
            "nombreProducto":this.newMercancia.nombreProducto,
            "cantidad":this.newMercancia.cantidad,
            "fechaIngreso":this.newMercancia.fechaIngreso,
            "usuarioCreacion":this.newMercancia.usuarioCreacion,
            "usuarioModificacion":this.usuarioModSeleccionado,
            "fechaModificacion":moment().format('YYYY-MM-DD'),
            "estado":this.newMercancia.estado
        });
        this.limpiarObjeto()
        this.obtenerListadoMercancia();
      },

      async eliminar(deleteMercancia) {
        const response = await mercanciaServicio.eliminar({
          id:deleteMercancia.id
        });
        this.mesage = response.data.msg
        this.obtenerListadoMercancia();
      },

      async buscar(){
        const response = await mercanciaServicio.buscar({
          nombre:this.filtroNombre
        });
        this.mercancias = response.data.listaMercancia
      },

      async listaUsuarios() {
        const response = await usuarioServicio.obtenerUsuarios();
        console.log(response.data)
        this.usuarios = response.data.listaUsuarios
      },
      async guardarMonedas() {
            const response = await movimientoAlcanciaServicio.guardarMovimiento({
              idAlcancia:this.alcancia.id,
              idMoneda:this.monedaSeleccionado.id,
              cantidad:this.cantidad
            });
            // toastr.success(response.data.message);
            // this.listarOpciones()
            this.limpiarObjeto()
            this.obtenerInfoAlcancia(this.$route.params.nombre);
      },
      async obtenerCantidadMonedas() {
          const response = await movimientoAlcanciaServicio.obtenerCantidadMonedas({
            idAlcancia:this.alcancia.id
          });
          this.cantidadMonedas = response.data.cantidadMonedas
      },
      limpiarObjeto() {
        this.idMercancia = null
        this.newMercancia.nombreProducto = ''
        this.newMercancia.cantidad = ''
        this.usuarioSeleccionado = {}
        this.usuarioModSeleccionado = {}
      },
      async buscarCantidadDenominacion() {
        const response = await movimientoAlcanciaServicio.obtenerCantidadMonedasPorDenominacion({
          idAlcancia:this.alcancia.id,
          idMoneda:this.denominacionSeleccionado.id
        });
        this.cantidadDenominacion = response.data.cantidadMonedasPorDenominacion
      },
      async buscarDineroDenominacion() {
        const response = await movimientoAlcanciaServicio.obtenerDineroPorDenominacion({
          idAlcancia:this.alcancia.id,
          idMoneda:this.denominacionDineroSeleccionado.id
        });
        this.cantidadDineroDenominacion = response.data.cantidadDineroPorDenominacion
      }
    },
    mounted() {
        this.obtenerListadoMercancia();
    },

}
</script>
<style>
.vdp-datepicker {
    position: relative;
    text-align: center;
}
.titulo1{
  border-bottom-style: inset
}
.titulo2{
  border-bottom-style: inset
}
.crud-administracion{
  padding-top: 5px;
}
.card-body-mercancia {
  padding: 0px;
}
.mitabla{
  text-align: -webkit-right;
}
table {
  border: 1px solid #0443b8;
  border-radius: 3px;
  background-color: #fff;
  text-align: -webkit-right;
}

th {
  background-color: #0443b8;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 100px;
  padding: 2px 2px;
}

th.active {
  color: #fff;
}
</style>