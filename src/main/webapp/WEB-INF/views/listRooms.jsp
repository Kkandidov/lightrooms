<div class="col-md-6 offset-md-3">
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Room name</th>
					<th scope="col">Country name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="room" items="${listRooms}">
					<tr>
					    <td><a href="${contextRoot}/show/${room.id}/room">${room.roomName}</a></td>
						<td>${room.countryName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>