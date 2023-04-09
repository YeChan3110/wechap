document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    var city = document.querySelector('#city').value;
    window.location.href = '/weather?city=' + encodeURIComponent(city);
});