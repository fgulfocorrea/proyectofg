<template>
    <div class="Role">
        <div class="card-body card-body-role text-center">
          <h4 class="titulo1">{{titulo}}</h4>
            <form>
              <div class="row">
                <div class="col-sm-12 text-left">
                  <label for="inputNombre" class="sr-only">Nombre </label>
                  <input
                    v-model="newRole.nombre"
                    type="text"
                    id="inputNombre"
                    class="form-control"
                    placeholder="Nombre"
                    required
                    autofocus
                    ref="nombre"
                  />
                </div>
              </div> 
              <div class="row">
                <div class="col-sm-12 text-left">
                  <label for="inputDescripcion" class="sr-only">Descripcion </label>
                  <input
                    v-model="newRole.descripcion"
                    type="text"
                    id="inputDescripcion"
                    class="form-control"
                    placeholder="Descripcion"
                    required
                    autofocus
                    ref="descripcion"
                  />
                </div>
              </div>
              <div class="row mt-2">
                <div v-if="this.guardar" class="col-sm-12">
                  <button type="submit" @click.prevent="crearRole" class="btn btn-outline-info active">Guardar</button>
                </div>
                <div v-else class="col-sm-12">
                  <button type="submit" @click.prevent="actualizarRole(newRole.id)" class="btn btn-outline-info active">Modificar</button>
                </div>
              </div>
              <div class="col-sm-12 mitabla">
                <table>
                  <thead>
                      <th>Nombre</th>
                      <th>Descripcion</th>
                  </thead>
                  <tbody v-if="roles.lenght == 0">
                    <h3 type="info">
                      {{msg}}
                    </h3>
                  </tbody>
                  <tbody v-if="roles.lenght != 0">
                    <tr v-for="role in roles" :key="role.id">
                      <td>
                        {{role.nombre}}
                      </td>
                      <td>
                        {{role.descripcion}}
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

import roleServicio from '@/services/RoleServicio'

export default {
    name: 'role',
    data (){
      return {
        newRole:{
          nombre:"",
          descripcion:"",
          estado:1
        },
        guardar:true,
        msg:'',
        roles: [],
        titulo: "Listado Roles"
      }
    },
    beforeUpdate(){
    },
    methods: {

      async obtenerListadoRoles() {
        const response = await roleServicio.listadoRoles();
        console.log(response.data)
        this.roles = response.data.listaRoles
        this.msg = response.data.msg

      },

      async crearRole(){
        const response = await roleServicio.guardar({
              "nombre":this.newRole.nombre,
              "descripcion":this.newRole.descripcion,
              "estado":this.newRole.estado
        });
      },

      async actualizarRole(id) {
        console.log('actualizando')
        // const response = await OpcionDisponibleServicio.modificar(
        //   { id,
        //     newOpcionAdministrable: this.newOpcionAdministrable
        //   });
        //   toastr.success(response.data.message);
        //   this.listarOpciones()
        //   this.limpiarObjeto()
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
      }
    },
    mounted() {
        this.obtenerListadoRoles();
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
.card-body-role {
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