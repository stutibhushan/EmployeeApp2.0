Ext.define('EmployeeApp.view.EmployeeGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.displayViewGrid',
	id: 'display-view',
	store: 'EmployeeDetailStore',
	
	
	
    //title: 'Active Promotions',
	
	
    columns:[{
        // id assigned so we can apply custom css (e.g. .x-grid-cell-topic b { color:#333 })
        // TODO: This poses an issue in subclasses of Grid now because Headers are now Components
        // therefore the id will be registered in the ComponentManager and conflict. Need a way to
        // add additional CSS classes to the rendered cells.
        
        text:'EMPLOYEE_ID',
        dataIndex: 'id',
        flex: 1,
        
        sortable: false
    },
    {
       
        text: "EMPLOYEE_NAME",
        dataIndex: 'name',
        width: 150,
       
        sortable: false
    },
    {
        text: "EMPLOYEE_TYPE",
        dataIndex: 'type',
        width: 50,
        sortable: false
    }/*,
    {
        id: 'departmentName',
        text: "DEPARTMENT_NAME",
        dataIndex: 'departmentList',
        width: 50,
        renderer: function(value)
        {   
        	console.log("in renderer");
        	var department= "";
        	for(var i=0; i<value.length; i++ )
        		{
        		department= value[i]+","+department;
        		}
        	return department;
        },
        sortable: false
    }*/,
    {
       
        text: "SALARY",
        dataIndex: 'salary',
        width: 100,
        sortable: false
    },
    {
        
        text: "ADDRESS",
        dataIndex: 'address',
        width: 150,
        //renderer: renderFirst,
        sortable: false
    },
    {
        
        text: "CITY",
        dataIndex: 'city',
        width: 100,
        sortable: false
    },
    {
       
        text: "STATE",
        dataIndex: 'state',
        width: 150,
        //renderer: renderFirst,
        sortable: false
    },
    {
        
        text: "COUNTRY",
        dataIndex: 'country',
        width: 50,
        sortable: false
    },
    
    {
       
        text: "START_DATE",
        dataIndex: 'startDate',
        width: 50,
        //renderer: renderFirst,
        sortable: false
    },
    {
       
        text: "END_DATE",
        dataIndex: 'endDate',
        sortable: false
    },
    
 ],
    
 bbar: [{xtype:'paging'}],
   
});

