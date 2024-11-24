import { SxProps } from "@mui/material";

export default function registrationStyles() {
    const styles:Record<any, SxProps> = {
        main: {
            textAlign: 'center', // `text-align` converted to `textAlign`
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            width: '100%', // `100%` remains as a string
        },
        outerWidget: {
            width: '18%',
            padding: '30px', // padding value in string format
            border: '1px solid black', // border style
            '& div': { // Targeting child `div` elements
                margin: '8px',
                fontSize: '12px',
            },
        },
        registrationForm: {
            display: 'flex',
            flexDirection: 'column',
        },
        signUpButton: {
            borderRadius: '6px', // Direct mapping for `border-radius`
        },
        inputBox:{
            margin:'5px !important',
            '& .MuiInputBase-input':{
                padding:'5px',
            },
            '& .MuiInputBase-root':{
                margin:'0px',
            }
        }
    };
    return styles;
}
