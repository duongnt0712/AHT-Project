# SPRING MVC

### Prerequisites
- Spring Core
- JDBC
- Servlet
- JSP

## 1. Workflow
- Every `request` will be sent to `Dispatcher Servlet` (Front Controller).
- `Dispatcher Servlet` use `Handler Mapping` to match which `controller` execute this `request`
- `Controller` receive `request`, then sent to the proper service class to execute.
- After that, `Controller` will sent the received model to `Dispatcher Servlet`
- `Dispatcher Servlet` will find view using `View Resolver` and pass model into it
- View template, model, view page will be built and send back to `Dispatcher Servlet`
- `Dispatcher Servlet` send page view to the browser to displayfor user.

## 2. Create a Spring MVC project?
1. Create maven project using `web-app`
2. Create `web.xml` inside `webapp/WEB-INF`
3. Add dependencies and servlet
4. Create `Config File` (2 ways below)
5. Create `Controller` to execute
6. Create `View`

## 3.  Configuration
1. Annotation
Need 2 config class:
- A class extends `AbstractAnnotationConfigDispatcherServletInitializer` to initial app.
- A class extends `WebMvcConfigurerAdapter` to config resources + initialize bean (include `viewResolver`):
<br/>`@EnableWebMvc`
<br/>`@Configuration`
<br/>`@ConponentScan("package-path")`

2. XML file: 
Need 2 config file:
- `web.xml`
- `<servlet-name>-servlet.xml`: include `InternalResourceViewResolver`

## 4. Request Mapping
- `@RequestMapping` to map request with the method execute it
- Apply for controller or method inside controller
	+ `@RequestMapping` with multiple url: `@RequestMapping(value = {"/", "/home"})`
	+ `@RequestMapping` with HTTP method: `@RequestMapping(value = "/test", method = RequestMethod.GET)`
	+ `@RequestMapping` with header: `@RequestMapping(value = "/test", headers= "name=kai")`
	+ `@RequestMapping` with **Produces** and **Consumes**: `@RequestMapping(value = "/test", produces = {"application/json"}, consumes = "text/html")`
	<br/> **consumes**: only accept requests which content-type similar to current value
	<br/> **produces**: data type of the return value, (usually use for **REST-API**)

## 5. Form Handling
- Textarea:
`<form:textarea path="address" row="5" cols="30" />`
- Password:
`<form:password path="password">`
- Checkbox:
`<form:checkbox path="receivePaper">`
- Checkboxes:
`<form:checkboxes items="${list}" path="receivePaper">`
- RadioButton:
`<form:radiobutton path="gender" value="M" label="Male">`
- RadioButtons:
`<form:radiobuttons path="gender" items="${numberList}">`
- Dropdown:
```
<form:select path = "country">
   <form:option value = "NONE" label = "Select"/>
   <form:options items = "${countryList}" />
</form:select>
```
- Listbox:
`<form:select path="skills" items="${list}" multiple="true">`
- Hidden field:
`<form:hidden path="id" value="1">`
- Error:
`form:errors path="name" cssClass="error"`