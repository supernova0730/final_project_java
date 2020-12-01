<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap" rel="stylesheet"/>

    <title>Index</title>

    <link href="${ pageContext.request.contextPath }/view/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/assets/css/fontawesome.css" />
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/assets/css/templatemo-stand-blog.css"/>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/assets/css/owl.css" />
</head>
<body>
    <jsp:include page="includes/header.jsp" />

    <div class="heading-page header-text">
        <section class="page-heading">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-content">
                            <h4>contact us</h4>
                            <h2>let’s stay in touch!</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <!-- Banner Ends Here -->


    <section class="contact-us">
        <div class="container">
            <div class="row">

                <div class="col-lg-12">
                    <div class="down-contact">
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="sidebar-item contact-form">
                                    <div class="sidebar-heading">
                                        <h2>Send us a message</h2>
                                    </div>
                                    <div class="content">
                                        <form id="contact" action="" method="post">
                                            <div class="row">
                                                <div class="col-md-6 col-sm-12">
                                                    <fieldset>
                                                        <input name="name" type="text" id="name" placeholder="Your name" required="">
                                                    </fieldset>
                                                </div>
                                                <div class="col-md-6 col-sm-12">
                                                    <fieldset>
                                                        <input name="email" type="text" id="email" placeholder="Your email" required="">
                                                    </fieldset>
                                                </div>
                                                <div class="col-lg-12">
                                                    <fieldset>
                                                        <textarea name="message" rows="6" id="message" placeholder="Your Message" required=""></textarea>
                                                    </fieldset>
                                                </div>
                                                <div class="col-lg-12">
                                                    <fieldset>
                                                        <button type="submit" id="form-submit" class="main-button">Send Message</button>
                                                    </fieldset>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="sidebar-item contact-information">
                                    <div class="sidebar-heading">
                                        <h2>contact information</h2>
                                    </div>
                                    <div class="content">
                                        <ul>
                                            <li>
                                                <h5>090-484-8080</h5>
                                                <span>PHONE NUMBER</span>
                                            </li>
                                            <li>
                                                <h5>info@company.com</h5>
                                                <span>EMAIL ADDRESS</span>
                                            </li>
                                            <li>
                                                <h5>123 Aenean id posuere dui,
                                                    <br>Praesent laoreet 10660</h5>
                                                <span>STREET ADDRESS</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12">
                    <div id="map">
                        <iframe src="https://maps.google.com/maps?q=Av.+L%C3%BAcio+Costa,+Rio+de+Janeiro+-+RJ,+Brazil&t=&z=13&ie=UTF8&iwloc=&output=embed" width="100%" height="450px" frameborder="0" style="border:0" allowfullscreen></iframe>
                    </div>
                </div>

            </div>
        </div>
    </section>

    <jsp:include page="includes/footer.jsp" />

    <script src="${ pageContext.request.contextPath }/view/vendor/jquery/jquery.min.js"></script>
    <script src="${ pageContext.request.contextPath }/view/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/custom.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/owl.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/slick.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/isotope.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/accordions.js"></script>

    <script language="text/Javascript">
        cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
        function clearField(t) {
            //declaring the array outside of the
            if (!cleared[t.id]) {
                // function makes it static and global
                cleared[t.id] = 1; // you could use true and false, but that's more typing
                t.value = ""; // with more chance of typos
                t.style.color = "#fff";
            }
        }
    </script>
</body>
</html>