/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

   
    
      cedula: { //nombre del atributo
        type: 'String',
        required: true,
        //columnName: 'usr_cedula',
        unique: true,
        minLength: 10,
        maxLength: 25
      },

      nombre:{
        type: 'string',
        minLength: 3,
        required: true,// por defecto ya es falso

      },
      correo:{
        type: 'String',
        isEmail: true
      }, 
      estadoCivil:{
        type: 'String',
        isIn:['Soltero','Casado','Divorciado','Viudo','UnionLibre'],
        defaultsTo:'soltero'

      },
      password:{
        type:'String',
      
        regex: /^[a-zA-Z]\w{3,14}$/
      },
    
      pokemons: { // One to Many (plural)
        collection: 'pokemon', // Referencia al modelo
        via: 'usuario' // Nombre Foreign Key en 'Pokemon'
      }

  },

};

