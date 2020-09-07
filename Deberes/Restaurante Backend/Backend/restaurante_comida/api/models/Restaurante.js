/**
 * Restaurante.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

      nombre:{
          type: 'string',
          minLength: 10,
          required: true

      },
      
      numeroIngredientes:{
        type: 'string',
        minLength:3,
        required: true

      },
      fechaRealizada:{
        type: 'string',
        minLength: 10,
        required: true
      }
      



  },

};

