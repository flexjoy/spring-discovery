//
// Delete person.
//
function confirm_delete(id, request, csrf, deleteUrl, doneUrl) {
    if (!confirm(request)) {
        return false;
    }
    $.ajax({
        method: "POST",
        url: deleteUrl,
        data: {
            id: id,
            _method: "DELETE",
            _csrf: csrf
        }
    }).done(function() {
        window.location.replace(doneUrl)
    });
}
