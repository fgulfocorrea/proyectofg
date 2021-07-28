<template>
    <div class="Usuario">
        <div class="card-body card-body-usuario text-center">
          <h4 class="titulo1">{{titulo}}</h4>
            <form>
              <div class="row">
                <!-- <div class="col-sm-12 text-left"> 
                  <label for="inputNombreProducto" class="sr-only">Nombre Producto</label>
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
                  <label for="inputCantidad" class="sr-only">Cantidad</label>
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
                </div>-->
            </div>
              <div class="col-sm-12 mitabla">
                <table>
                  <thead>
                      <th>Nombre</th>
                      <th>Fecha Ingreso</th>
                      <th>Role</th>
                  </thead>
                  <tbody v-if="usuarios.lenght == 0">
                    <v-alert type="info">
                      {{msg}}
                    </v-alert>
                  </tbody>
                  <tbody>
                    <tr v-for="usuario in usuarios" :key="usuario.id">
                      <td>
                        {{usuario.nombre}}
                      </td>
                      <td>
                        {{usuario.fecha_ingreso}}
                      </td>
                      <td>
                        {{usuario.role.nombre}}
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
          </form>
          <!-- <div class="row"/> 
            <form>
            <h4 class="titulo2">Cantidad Monedas Por Denominación</h4>
            <label for="denominacion">Denominacion </label>
            <select v-model="denominacionSeleccionado" class="form-control" id="denominacionCantidad">
                <option v-for="moneda in monedas" :key="moneda.id" :value="moneda">{{moneda.nombre}}</option>
            </select>
            <button type="submit" @click.prevent="buscarCantidadDenominacion" class="btn btn-outline-info active">Buscar</button>
            </form>
            <div class="row">
              <label for="cantidadDenominacion">Cantidad : {{ cantidadDenominacion }} </label>
            </div>
            <div class="row"/>
            <form>
              <h4 class="titulo2">Total Dinero Por Denominación</h4>
              <label for="denominacion">Denominacion </label>
              <select v-model="denominacionDineroSeleccionado" class="form-control" id="denominacionDinero">
                  <option v-for="moneda in monedas" :key="moneda.id" :value="moneda">{{moneda.nombre}}</option>
              </select>
              <button type="submit" @click.prevent="buscarDineroDenominacion" class="btn btn-outline-info active">Buscar</button>
            </form>
            <div class="row">
              <label for="cantidadDenominacion">Total Dinero : $ {{ cantidadDineroDenominacion }} </label>
            </div>
        </div> -->
      </div>
    </div>
</template>

<script>
/* eslint-disable */

import usuarioServicio from '@/services/UsuarioServicio'
import mercanciaServicio from '@/services/MercanciaServicio'
import Datepicker from 'vuejs-datepicker';
import moment from "moment";

export default {
    name: 'Usuario',
    components: { 
        Datepicker,
    },
    data (){
      return {
        newMercancia:{
          nombreProducto:"",
          cantidad:1,
          fechaIngreso:"",
          usuarioCreacion:"",
          usuarioModificacion:"",
          fechaModificacion:"",
          estado:1
        },
        msg:'',
        usuarios: [],
        event_at: new Date(),
        titulo: "Listado Usuarios",
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
    beforeUpdate(){
    },
    methods: {

      async obtenerListadoUsuarios() {
        const response = await usuarioServicio.obtenerUsuarios();
        console.log(response.data)
        this.usuarios = response.data.listaUsuarios
        this.msg = response.data.msg
        
        // this.obtenerMonedas(this.alcancia.pais);
        // this.obtenerCantidadMonedas()
      },

      async obtenerMonedas(pais) {
          console.log("nombre:"+pais)
        const response = await monedaServicio.obtenerMonedas({pais: pais});
        console.log(response.data)
        this.monedas = response.data.listaMonedas
        this.denominaciones = response.data.listaMonedas
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
        this.alcancia.id = null
        this.alcancia.nombre = ''
        this.alcancia.pais = ''
        this.alcancia.totalDinero = null
        this.cantidad = ''
        this.monedaSeleccionado = {}
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
      },
      customFormatter(date) {
            return moment(date).format('D MMMM YYYY');
      }
    },
    mounted() {
        this.obtenerListadoUsuarios();
    },

}
</script>
<style>

.titulo1{
  border-bottom-style: inset
}
.titulo2{
  border-bottom-style: inset
}
.crud-administracion{
  padding-top: 5px;
}
.card-body-usuario {
  padding: 0px;
}
.mitabla{
  text-align: -webkit-center;
}
table {
  border: 1px solid #0443b8;
  border-radius: 3px;
  background-color: #fff;
  text-align: -webkit-center;
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