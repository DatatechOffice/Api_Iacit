
function sla(){
    document.getElementById("texto").innerHTML = "aaa";
} 


$('input.timepicker').timepicker({
    timeFormat: 'HH:mm:ss',
});


var timepicker = new TimePicker('time', {
    lang: 'en',
    theme: 'dark'
  });
  timepicker.on('change', function(evt) {
    
    var value = (evt.hour || '00') + ':' + (evt.minute || '00');
    evt.element.value = value;
  
  });