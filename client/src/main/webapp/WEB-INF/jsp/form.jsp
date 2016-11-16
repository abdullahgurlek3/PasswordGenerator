<%-- 
    Document   : index
    Created on : Aug 3, 2016, 19:52:55 PM
    Author     : Abdullah Gürlek
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Generator </title>
        <style>
            .error{
                color:red;
                font-weight: bold;
            }

        </style>
    </head>
    <body>
        <h1>Password Generator</h1>
        <form:form method="POST" modelAttribute="Password">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>Password Length :</td>
                    <td><form:input path="length" />
                    </td>
                    <td><form:errors path="length" cssClass="error" />
                    </td>
                </tr>

                <tr>
                    <td>Include Letters :</td>
                    <td><form:checkbox path="includeLetters" />
                    </td>
                    <td><form:errors path="includeLetters" cssClass="error" />
                    </td>
                </tr>



                <tr>
                    <td>Include UpperCase Letters :</td>
                    <td><form:checkbox path="includeMixedCase" />
                    </td>
                    <td><form:errors path="includeMixedCase" cssClass="error" />
                    </td>
                </tr>

                <tr>
                    <td>Include Numbers :</td>
                    <td><form:checkbox path="includeNumber" />
                    </td>
                    <td><form:errors path="includeNumber" cssClass="error" />
                    </td>
                </tr>


                <tr>
                    <td>Include Punctuations :</td>
                    <td><form:checkbox path="includePunctuation" />
                    </td>
                    <td><form:errors path="includePunctuation" cssClass="error" />
                    </td>
                </tr>

                <tr>
                    <td>No similar Characters:</td>
                    <td><form:checkbox path="noSimilarCharacters" />
                    </td>
                    <td><form:errors path="noSimilarCharacters" cssClass="error" />
                    </td>
                </tr>

                <tr>
                    <td>Quantity</td>
                    <td><form:select path="quantity"  >
                            <form:option value="-4">-4</form:option>
                            <form:option value="-1">-1</form:option>
                            <form:option value="0">0</form:option>
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="8">8</form:option>
                            <form:option value="16">16</form:option>
                            <form:option value="32">32</form:option>
                            <form:option value="64">64</form:option>

                        </form:select>
                    </td>
                    <td><form:errors path="quantity" cssClass="error" />
                    </td>
                </tr>


                <tr>
                    <td colspan="3"><input type="submit" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
