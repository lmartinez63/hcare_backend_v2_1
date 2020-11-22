<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <style>
        table {
            font-family: calibri;
        }
        .titleMain {
            font-size: 28px;
            font-weight: bold;
            color: #597db7;
            text-transform: uppercase;
            padding: 10px 20px 0px 20px;
        }
        .subTitle {
            font-size: 22px;
            font-weight: bold;
            color: #597db7;
            text-transform: uppercase;
            padding: 10px 20px 0px 20px;
        }
        .descrip {
            font-size: 14px;
            color: #252525;
            line-height: 32px;
                padding: 0 20px;
        }
        .separator {
            height: 40px;
        }
        .empresa {
            color: #597db7;
            font-weight: bold;
        }
        .pe {
            color: #a8c6e7;
            font-weight: bold;
        }
        table {
            background-color: #f1f5f8;
        }
		.paddingTd {
			padding: 20px;
		}
		.imagenCita {
			position: absolute;
			bottom: 20px;
			right: 20px;
		}
        .logo {
            text-align: center;
            padding: 0;
            margin: 0;
            height: 120px;
        }
        .saludo {
            font-size: 16px;
            font-weight: bold;
            color: #597db7;
            padding: 10px 20px 0 20px;
        }
        .empresa {
            font-size: 18px;
            font-weight: bold;
            color: #597db7;
            text-transform: uppercase;
            margin-bottom: 20px;
            padding: 10px 20px 20px 20px;
        }
        ul {
            list-style: none;
            font-size: 14px;
            font-weight: 600;
        }
        .link {
            color: #29b6f6;
            font-weight: bold;
            cursor: pointer;
            font-size: 14px;
            padding: 10px 20px 20px 20px;
        }
        .btn {
            width: 120px;
            font-size: 14px;
            font-weight: bold;
            padding: 8px;
            border-radius: 15px;
            text-align: center;
            text-transform: uppercase;
            margin: 10px 0;
            cursor: pointer;
            margin: 10px 20px 20px 20px;
        }
        .btn.main {
            background: #29b6f6;
            color: #fff;
        }
    </style>
</head>
<body>
    <center>
    <table style="width: 750px; height: 600px;">
        <tr>
            <td class="logo">
                <img width="400px" src="${Properties["frontEndUrl"]}/static/img/logo.png" />
            </td>
        </tr>
        <tr>
            <td class="paddingTd">
				<table style="background:#fff;border: 1px solid #41afb0;width: 100%;height: 100%; position:relative;">
					<tr>
						<td>
                            <div class="subTitle">Estimado(a) Doctor(a) ${Doctor.fullName}</div>
                            <div class="descrip">Tiene una cita programada: </div>
                            <div class="descrip">Fecha: ${MedicalAppointment.dateAppointmentDateFormatted}</div>
                            <div class="descrip">Hora: ${MedicalAppointment.dateAppointmentTimeFormatted}</div>
                            <div class="descrip">Paciente: ${MedicalAppointment.patient.fullName}</div>

                            <div class="descrip">Cualquier duda no dude en contactarnos</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="saludo" >Atentamente,</div>
                            <div class="empresa" >NovaClinic</div>
						</td>
					</tr>

				</table>
            </td>
        </tr>
    </table>
    </center>
</body>
</html>