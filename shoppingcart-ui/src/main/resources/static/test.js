+ function() {

    $.get('/ui/catalog-service/api/products', function(data){
        $('BODY').html(data)
    });

} ();