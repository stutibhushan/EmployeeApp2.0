Ext.define('EmployeeApp.model.EmployeeVOModel', {
	extend: 'Ext.data.Model',
	

	 fields: [
	            'name','address','city','state','country','salary','startDate','endDate','type',
	            {name: 'id', type: 'int'},
	            
	        ],
	        idProperty: 'id'
});


