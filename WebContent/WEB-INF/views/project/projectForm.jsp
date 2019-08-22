<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/view/includeResources.jsp" />
</head>
<body>
 <!-- Start of Project FORM -->

    <div class="project">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <h5 class="display-4 text-center">Create Project form</h5>
                    <hr />
                    <s:form  method="post" modelAttribute="project">
                        <div class="form-group">
                            <s:input  class="form-control form-control-lg " path="project_name" placeholder="Project Name" />
                        </div>
                        <div class="form-group">
                            <s:input  class="form-control form-control-lg" path="project_identifier" placeholder="Unique Project ID"
                                />
                        </div>
                        <!-- disabled for Edit Only!! remove "disabled" for the Create operation -->
                        <div class="form-group">
                            <s:textarea class="form-control form-control-lg" path="description" placeholder="Project Description"></s:textarea>
                        </div>
                        <h6>Start Date</h6>
                        <div class="form-group">
                            <s:input type="date" class="form-control form-control-lg" path="start_date" />
                        </div>
                        <h6>Estimated End Date</h6>
                        <div class="form-group">
                            <s:input type="date" class="form-control form-control-lg" path="end_date" />
                        </div>

                        <input type="submit" class="btn btn-primary btn-block mt-4" />
                    </s:form>
                </div>
            </div>
        </div>
    </div>

    <!-- END OF PROJECT FORM -->
</body>
</html>