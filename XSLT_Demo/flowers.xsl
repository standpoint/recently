<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math"
    exclude-result-prefixes="xs"
    version="3.0">
    <xsl:template match="/">
        <html>
            <head><title>Flowers</title></head>
            <body>
                <table border="1">
                    <tr>
                        <th>Id flower</th>
                        <th>name</th>
                        <th>soil</th>
                        <th>origin</th>
                        <th>color</th>
                    </tr>
                    <xsl:for-each select="flowers/flower">
                        <tr>
                            <td><xsl:value-of select="@id"></xsl:value-of></td>
                            <td><xsl:value-of select="name"></xsl:value-of></td>
                            <td><xsl:value-of select="soil"></xsl:value-of></td>
                            <td><xsl:value-of select="origin"></xsl:value-of></td>
                            <td><xsl:value-of select="parameters/color"></xsl:value-of></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>