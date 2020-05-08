<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-6 offset-md-3">
	<div class="container">
	
		<c:if test="${not empty message}">
			<div class="alert alert-success alert-dismissible fade show" role="alert">
				<strong>${message}</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>	
		<div class="card">
			<div class="card-header">
				<strong>Room Registration</strong>
			</div>
			<div class="card-body">
				<sf:form modelAttribute="room"
					action="${contextRoot}/registration"
					method="POST">
					<div class="form-group">
						<label>Room name</label>
						<sf:input type="text" path="roomName" class="form-control" placeholder="Room name"/>
						<sf:errors path="roomName" cssClass="help-block" element="em"/>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Choose the country of the room</label>
							<sf:select class="form-control" path="countryName">
								<sf:options items="${countryNames}"/>
							</sf:select>							
						</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</sf:form>		
			</div>
		</div>
	</div>
</div>









