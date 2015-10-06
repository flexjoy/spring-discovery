//
// Delete person.
//
function confirm_delete(id, request, deleteUrl, doneUrl) {
    if (!confirm(request)) {
        return false;
    }
    $.ajax({
        method: "POST",
        url: deleteUrl,
        data: {
            id: id,
            _method: "DELETE",
        }
    }).done(function() {
        window.location.replace(doneUrl)
    });
}
